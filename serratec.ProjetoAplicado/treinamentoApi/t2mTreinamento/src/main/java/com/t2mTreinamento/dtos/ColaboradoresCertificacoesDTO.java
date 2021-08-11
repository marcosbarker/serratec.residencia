package com.t2mTreinamento.dtos;

import java.util.Calendar;

public class ColaboradoresCertificacoesDTO {
	private CertificacoesDTO certificacao;
	private Calendar dataObtencao;

	public CertificacoesDTO getCertificacao() {
		return certificacao;
	}

	public void setCertificacao(CertificacoesDTO certificacao) {
		this.certificacao = certificacao;
	}

	public Calendar getDataObtencao() {
		return dataObtencao;
	}

	public void setDataObtencao(Calendar dataObtencao) {
		this.dataObtencao = dataObtencao;
	}

}
