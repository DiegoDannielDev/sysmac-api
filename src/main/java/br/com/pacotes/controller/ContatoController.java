package br.com.pacotes.controller;

import br.com.pacotes.entitys.Contato;
import br.com.pacotes.repositorys.ContatoRepository;
import br.com.pacotes.services.ContatoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/controller")
public class ContatoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContatoController.class);

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private ContatoService contatoService;


    @DeleteMapping(value = "/delete/{id}")
    public Boolean removeContato(@PathVariable Long id) {

        LOGGER.info("Deletando registro {}", id);
        try {
            this.contatoRepository.deleteById(id);
            LOGGER.info("Contato removido");
            return true;
        } catch (Exception e) {
            LOGGER.error("houve um erro ao remover registro na base de dados");
            throw new RuntimeException("houve um erro ao remover registro na base de dados " + e.getMessage());
        }

    }

    @PostMapping(value = "/salvar-contato", produces = MediaType.APPLICATION_JSON_VALUE, consumes = "application/json")
    @ApiOperation(httpMethod = "POST", value = "Responsavel por salvar um contato", response = Contato.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Um erro interno foi detectado")})
    public ResponseEntity<Contato> criaContato(@RequestBody Contato contato) {
        LOGGER.info("Salvando registro ");
        try {
            if (contato != null || contato.getNome() != null || contato.getDdd() != null) {
                Contato contato1 = new Contato(contato.getNome(), contato.getDdd(), contato.getTelefone());
                this.contatoRepository.save(contato1);
                return new ResponseEntity<>(contato1, HttpStatus.OK);
            } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
