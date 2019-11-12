package br.com.pacotes.models;

import br.com.pacotes.entitys.Contato;

public class ContatoMestico {

    private Pessoa pessoa;

    private Endereco endereco;

    public ContatoMestico() {
    }

    public ContatoMestico(Pessoa pessoa, Endereco endereco) {
        this.pessoa = pessoa;
        this.endereco = endereco;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


}