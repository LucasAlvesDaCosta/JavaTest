package com.lucasdev.sigabem.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.lucasdev.sigabem.entities.EnderecoViaCep;
@Service
public class viaCepService {

	@GetMapping
	public EnderecoViaCep viaCep(String cep) {
		
		return new EnderecoViaCep();
	}
}
