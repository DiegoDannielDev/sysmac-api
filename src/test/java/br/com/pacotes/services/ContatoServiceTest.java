package br.com.pacotes.services;

import br.com.pacotes.controller.ContatoController;
import br.com.pacotes.entitys.Contato;
import br.com.pacotes.repositorys.ContatoRepository;
import io.restassured.RestAssured;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = {"test"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContatoServiceTest {

    @Value("${local.server.port}")
    protected int porta;

    @Autowired
    private ContatoController contatoController;
    @Autowired
    private ContatoRepository contatoRepository;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Contato contato;

    @Before
    public void start() {
        RestAssured.port = porta;
        contatoRepository.deleteAll();
        contato = new Contato("Chefe", "0y", "9xxxxx9");
        contatoController.criaContato(contato);
        contato = new Contato("Diego", "0y", "974875555");
        contatoController.criaContato(contato);
        contato = new Contato("Maria", "0y", "95822111");
        contatoController.criaContato(contato);
        contato = new Contato("joão", "0y", "85875222");
        contatoController.criaContato(contato);
        contato = new Contato("thiago", "0y", "85782222");
        contatoController.criaContato(contato);
        contato = new Contato("pedro", "0y", "985874111");
        contatoController.criaContato(contato);


    }

    @After
    public void end() {
        contatoRepository.deleteAll();
    }

    @Test
    public void findByNomeRetornaContato() throws Exception {
        Contato contato = contatoRepository.findFirstByNome("thiago");
        Assert.assertTrue(contato.getNome().equalsIgnoreCase("thiago"));
    }

//
//    @Test(expected = Exception.class)
//    public void saveComDddNulloDeveLancarException(){
//        expectedException.expect(ConstraintViolationException.class);
//        expectedException.expectMessage("O DDD DEVE SER PREENCHIDO");
//
//        contato.setDdd(null);
//        contatoController.criaContato(contato);
//
//
//    }

}
