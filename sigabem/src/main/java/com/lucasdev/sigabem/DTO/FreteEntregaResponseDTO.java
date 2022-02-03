package com.lucasdev.sigabem.DTO;

import java.io.Serializable;
import java.time.LocalDate;

import com.lucasdev.sigabem.entities.Entrega;

public class FreteEntregaResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String cepOrigem;
	private String cepDestino;
	private Double vlTotalFrete;
	private LocalDate dataPrevistaEntrega;
	
	public FreteEntregaResponseDTO() {
		
	}

	public FreteEntregaResponseDTO(Entrega entity) {
		id = entity.getId();
		cepOrigem = entity.getCepOrigem();
		cepDestino = entity.getCepDestino();
		vlTotalFrete = entity.getVlTotalFrete();
		dataPrevistaEntrega = entity.getDataPrevistaEntrega();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCepOrigem() {
		return cepOrigem;
	}

	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}

	public String getCepDestino() {
		return cepDestino;
	}

	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}

	public Double getVlTotalFrete() {
		return vlTotalFrete;
	}

	public void setVlTotalFrete(Double vlTotalFrete) {
		this.vlTotalFrete = vlTotalFrete;
	}

	public LocalDate getDataPrevistaEntrega() {
		return dataPrevistaEntrega;
	}

	public void setDataPrevistaEntrega(LocalDate dataPrevistaEntrega) {
		this.dataPrevistaEntrega = dataPrevistaEntrega;
	}
	
}
