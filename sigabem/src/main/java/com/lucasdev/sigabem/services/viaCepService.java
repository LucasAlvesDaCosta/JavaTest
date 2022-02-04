package com.lucasdev.sigabem.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lucasdev.sigabem.entities.EnderecoViaCep;

@Service
public class viaCepService {

	private RestTemplate restTemplate = new RestTemplate();

	public EnderecoViaCep viaCep(String cep) {

		StringBuilder stringBuilder = new StringBuilder(100);
		stringBuilder.append("https://viacep.com.br/ws/");
		stringBuilder.append(cep);
		stringBuilder.append("/json/");

		String url = stringBuilder.toString();
		EnderecoViaCep endereco = restTemplate.getForObject(url, EnderecoViaCep.class);

		return endereco;
	}
}
