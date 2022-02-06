package com.lucasdev.sigabem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasdev.sigabem.DTO.FreteEntregaDTO;
import com.lucasdev.sigabem.DTO.FreteEntregaResponseDTO;
import com.lucasdev.sigabem.services.EntregaService;

@Controller
@RestController
@RequestMapping(value = "/entregas/frete")
public class EntregaController {

	@Autowired
	private EntregaService service;

	@PostMapping
	public ResponseEntity<FreteEntregaResponseDTO> EntregaResourcePost(@RequestBody FreteEntregaDTO dto) {
		FreteEntregaResponseDTO response = service.calcularValorFretePrazo(dto);
		return ResponseEntity.ok().body(response);
	}

	@GetMapping(value = "/{peso}/{cepOrigem}/{cepDestino}/{nomeDest}")
	public ResponseEntity<FreteEntregaResponseDTO> EntregaResourceGet(@PathVariable("peso") Double peso,
			@PathVariable("cepOrigem") String cepOrigem, @PathVariable("cepDestino") String cepDestino,
			@PathVariable("nomeDest") String nomeDest) {

		FreteEntregaDTO dto = new FreteEntregaDTO();
		dto.setPeso(peso);
		dto.setCepOrigem(cepOrigem);
		dto.setCepDestino(cepDestino);
		dto.setNomeDestinatario(nomeDest);

		FreteEntregaResponseDTO response = service.calcularValorFretePrazo(dto);
		return ResponseEntity.ok().body(response);
	}
}
