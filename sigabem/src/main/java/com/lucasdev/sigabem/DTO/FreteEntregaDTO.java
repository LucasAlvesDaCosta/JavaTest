package com.lucasdev.sigabem.DTO;

import java.io.Serializable;

import com.lucasdev.sigabem.entities.Entrega;

public class FreteEntregaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Double peso;
	private String cepOrigem;
	private String cepDestino;
	private String nomeDestinatario;

	public FreteEntregaDTO() {
	}

	public FreteEntregaDTO(Long id, Double peso, String cepOrigem, String cepDestino, String nomeDestinatario) {
		super();
		this.id = id;
		this.peso = peso;
		this.cepOrigem = cepOrigem;
		this.cepDestino = cepDestino;
		this.nomeDestinatario = nomeDestinatario;
	}
	
	public FreteEntregaDTO(Entrega entity) {
		id = entity.getId();
		peso = entity.getPeso();
		cepOrigem = entity.getCepOrigem();
		cepDestino = entity.getCepDestino();
		nomeDestinatario = entity.getNomeDestinatario();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
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

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}
	
}
