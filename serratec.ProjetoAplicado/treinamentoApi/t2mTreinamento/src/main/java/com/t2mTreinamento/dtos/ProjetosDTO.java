package com.t2mTreinamento.dtos;

import java.util.Calendar;

public class ProjetosDTO {
	private Long idProjetos;

	private String nome;

	private String descricao;

	private String appGerenciamento;

	private String segmento;

	private Calendar dataEntregaEsperada;

	private Calendar dataEntrega;

	private Long equipe;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAppGerenciamento() {
		return appGerenciamento;
	}

	public void setAppGerenciamento(String appGerenciamento) {
		this.appGerenciamento = appGerenciamento;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public Calendar getDataEntregaEsperada() {
		return dataEntregaEsperada;
	}

	public void setDataEntregaEsperada(Calendar dataEntregaEsperada) {
		this.dataEntregaEsperada = dataEntregaEsperada;
	}

	public Calendar getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Long getEquipe() {
		return equipe;
	}

	public void setEquipe(Long equipe) {
		this.equipe = equipe;
	}

	public Long getIdProjetos() {
		return idProjetos;
	}

	public void setIdProjetos(Long idProjetos) {
		this.idProjetos = idProjetos;
	}

}
