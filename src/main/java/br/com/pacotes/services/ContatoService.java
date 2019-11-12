package br.com.pacotes.services;

import br.com.pacotes.models.ContatoMestico;
import br.com.pacotes.models.Endereco;
import br.com.pacotes.models.Pessoa;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    private PessoaService pessoaService = new PessoaService();

    private EnderecoService enderecoService = new EnderecoService();


    public ContatoMestico criaContato(String nome, String rua) {
        Pessoa pessoa = pessoaService.getPessoa(nome);
        Endereco endereco = enderecoService.getEndereco(rua);
        return new ContatoMestico(pessoa, endereco);
    }


}
