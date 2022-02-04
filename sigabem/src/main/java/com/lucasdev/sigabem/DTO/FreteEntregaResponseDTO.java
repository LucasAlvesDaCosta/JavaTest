package com.lucasdev.sigabem.DTO;

import java.io.Serializable;
import java.time.LocalDate;

import com.lucasdev.sigabem.entities.Entrega;

public class FreteEntregaResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String cepOrigem;
	private String cepDestino;
	private Double vlTotalFrete;
	private LocalDate dataPrevistaEntrega;
	
	public FreteEntregaResponseDTO() {
		
	}

	public FreteEntregaResponseDTO(String cepOrigem, String cepDestino, Double vlTotalFrete,
			LocalDate dataPrevistaEntrega) {
		super();
		this.cepOrigem = cepOrigem;
		this.cepDestino = cepDestino;
		this.vlTotalFrete = vlTotalFrete;
		this.dataPrevistaEntrega = dataPrevistaEntrega;
	}


	public FreteEntregaResponseDTO(Entrega entity) {
		cepOrigem = entity.getCepOrigem();
		cepDestino = entity.getCepDestino();
		vlTotalFrete = entity.getVlTotalFrete();
		dataPrevistaEntrega = entity.getDataPrevistaEntrega();
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
