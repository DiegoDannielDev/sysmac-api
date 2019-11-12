package br.com.pacotes.services;

import br.com.pacotes.models.Pessoa;

public class PessoaService {

	public Pessoa getPessoa(String nome) {
		return new Pessoa(nome);
	}

}
