package com.t2mTreinamento.dtos;

public class CertificacoesDTO {
	private Long idCertificacoes;
	private Double tempoValidade;
	private String nomeCertificado;
	private String instituicaoCertificado;

	public Double getTempoValidade() {
		return tempoValidade;
	}

	public void setTempoValidade(Double tempoValidade) {
		this.tempoValidade = tempoValidade;
	}

	public String getNomeCertificado() {
		return nomeCertificado;
	}

	public void setNomeCertificado(String nomeCertificado) {
		this.nomeCertificado = nomeCertificado;
	}

	public String getInstituicaoCertificado() {
		return instituicaoCertificado;
	}

	public void setInstituicaoCertificado(String instituicaoCertificado) {
		this.instituicaoCertificado = instituicaoCertificado;
	}

	public Long getIdCertificacoes() {
		return idCertificacoes;
	}

	public void setIdCertificacoes(Long idCertificacoes) {
		this.idCertificacoes = idCertificacoes;
	}

}
