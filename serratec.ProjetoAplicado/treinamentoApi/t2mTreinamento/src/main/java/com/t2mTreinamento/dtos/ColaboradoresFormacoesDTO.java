package com.t2mTreinamento.dtos;

import java.util.Calendar;

public class ColaboradoresFormacoesDTO {
	private FormacoesDTO formacao;
	private Calendar dataEntrada;
	private Calendar dataConclusao;

	public FormacoesDTO getFormacao() {
		return formacao;
	}

	public void setFormacao(FormacoesDTO formacao) {
		this.formacao = formacao;
	}

	public Calendar getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Calendar getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(Calendar dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

}
