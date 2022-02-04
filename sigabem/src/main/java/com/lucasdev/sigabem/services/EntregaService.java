package com.lucasdev.sigabem.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${value.kg}")// Value defined in application.properties - Default: 1.0 
	private Double valorKg;

	public FreteEntregaResponseDTO calcularValorFretePrazo(FreteEntregaDTO dto) {
		
		FreteEntregaResponseDTO response = new FreteEntregaResponseDTO();
		
		Double valorFrete = dto.getPeso() * valorKg;		
		LocalDate dataPrevEntrega = LocalDate.now();
		EnderecoViaCep origem = service.viaCep(dto.getCepOrigem());
		EnderecoViaCep destino = service.viaCep(dto.getCepDestino());
		
		if(origem.getDdd().equals(destino.getDdd())) {
			
			double percentual = 50.0 / 100.0; // 50%
			valorFrete -= (percentual * valorFrete);
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
		
		response.setVlTotalFrete((double) (Math.round(valorFrete*100.0)/100.0));
		response.setCepOrigem(dto.getCepOrigem());
		response.setCepDestino(dto.getCepDestino());
		
		insert(dto, response);
		return response;
	}
	
	public void insert(FreteEntregaDTO dto, FreteEntregaResponseDTO response) {
		Entrega entity = new Entrega();
		entity.setPeso(dto.getPeso());
		entity.setCepDestino(dto.getCepDestino());
		entity.setCepOrigem(dto.getCepOrigem());
		entity.setNomeDestinatario(dto.getNomeDestinatario());
		
		entity.setVlTotalFrete(response.getVlTotalFrete());
		entity.setDataPrevistaEntrega(response.getDataPrevistaEntrega());
		entity.setDataConsulta(LocalDate.now());
		
		repository.save(entity);
	}
}
