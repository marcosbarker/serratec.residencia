package com.t2mTreinamento.dtos;

import java.util.Calendar;

public class ColaboradoresProjetosDTO {
	private ProjetosDTO projeto;
	private String funcao;
	private Calendar dataInicio;
	private Calendar dataSaida;

	public ProjetosDTO getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetosDTO projeto) {
		this.projeto = projeto;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Calendar dataSaida) {
		this.dataSaida = dataSaida;
	}

}
