package com.lucasdev.sigabem.services;

import org.springframework.stereotype.Service;

import com.lucasdev.sigabem.entities.EnderecoViaCep;
@Service
public class viaCepService {

	public EnderecoViaCep viaCep(String cep) {
		EnderecoViaCep endereco = new EnderecoViaCep();
		 endereco.setCep("01001-000");
		 endereco.setLogradouro("Praça da Sé");
		 endereco.setBairro("Sé");
		 endereco.setLocalidade("São Paulo");
		 endereco.setUf("SP");
		 endereco.setIbge("3550308");
		 endereco.setGia("1004");
		 endereco.setDdd("11");
		 endereco.setSiafi("7103");
		
		return endereco;
	}
}
