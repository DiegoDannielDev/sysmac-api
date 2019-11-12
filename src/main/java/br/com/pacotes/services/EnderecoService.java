package br.com.pacotes.services;

import br.com.pacotes.models.Endereco;

public class EnderecoService {

	public Endereco getEndereco(String rua) {
		return new Endereco(rua);
	}

}
