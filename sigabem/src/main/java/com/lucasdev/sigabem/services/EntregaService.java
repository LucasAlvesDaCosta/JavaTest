package com.lucasdev.sigabem.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasdev.sigabem.DTO.FreteEntregaDTO;
import com.lucasdev.sigabem.DTO.FreteEntregaResponseDTO;
import com.lucasdev.sigabem.entities.EnderecoViaCep;
import com.lucasdev.sigabem.entities.Entrega;
import com.lucasdev.sigabem.repositories.EntregaRepository;

@Service
public class EntregaService {
	
	@Autowired
	private EntregaRepository repository;
	
	@Autowired
	private viaCepService service;
	/*
	 * Considerar regras para calcular o valor do frete:
	 * 
	 * CEPs com DDDs iguais tem 50% de desconto no valor do frete e entrega prevista
	 * de 1 dia #CEPs de estados iguais tem 75% de desconto no valor do frete e
	 * entrega prevista de 3 dias #CEPs de estados diferentes não deve ser aplicado o
	 * desconto no valor do frete e entrega prevista de 10 dias O valor do frete é
	 * cobrado pelo peso da encomenda, o valor para cada KG é R$1,00
	 */
	
	public FreteEntregaResponseDTO calcularValorFretePrazo(FreteEntregaDTO dto) {
		
		FreteEntregaResponseDTO response = new FreteEntregaResponseDTO();
		Double valorFrete = dto.getPeso() * 1L;
		LocalDate dataPrevEntrega = LocalDate.now();
		EnderecoViaCep origem = service.viaCep(dto.getCepOrigem());
		EnderecoViaCep destino = service.viaCep(dto.getCepDestino());
		
		if(origem.getDdd().equals(destino.getDdd())) {
			valorFrete /= 2L;
			dataPrevEntrega = dataPrevEntrega.plusDays(1);
			
			response.setVlTotalFrete(valorFrete);
			response.setDataPrevistaEntrega(dataPrevEntrega);
		}
		
		if(origem.getUf().equals(destino.getUf())) {
			
			double percentual = 75.0 / 100.0; // 75%
		    valorFrete -= (percentual * valorFrete);
		    dataPrevEntrega = dataPrevEntrega.plusDays(3);
		    
		    response.setVlTotalFrete(valorFrete);
		    response.setDataPrevistaEntrega(dataPrevEntrega);
		}
		
		if(!origem.getUf().equals(destino.getUf())) {
			
			dataPrevEntrega = dataPrevEntrega.plusDays(10);
			
			response.setDataPrevistaEntrega(dataPrevEntrega);
			response.setVlTotalFrete(valorFrete);
		}
		
		response.setCepOrigem(dto.getCepOrigem());
		response.setCepDestino(dto.getCepDestino());
		
		insert(dto, response);
		return response;
	}
	
	public void insert(FreteEntregaDTO dto, FreteEntregaResponseDTO response) {
		Entrega entity = new Entrega();
		entity.setCepDestino(dto.getCepDestino());
		entity.setCepOrigem(dto.getCepOrigem());
		entity.setNomeDestinatario(dto.getNomeDestinatario());
		
		entity.setVlTotalFrete(response.getVlTotalFrete());
		entity.setDataPrevistaEntrega(response.getDataPrevistaEntrega());
		entity.setDataConsulta(LocalDate.now());
		
		repository.save(entity);
	}
}
