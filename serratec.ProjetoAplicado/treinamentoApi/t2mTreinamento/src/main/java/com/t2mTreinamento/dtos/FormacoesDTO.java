package com.t2mTreinamento.dtos;

public class FormacoesDTO {
	private Long idFormacoes;
	private String nome;
	private String nivel;
	private String instituicao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public Long getIdFormacoes() {
		return idFormacoes;
	}

	public void setIdFormacoes(Long idFormacoes) {
		this.idFormacoes = idFormacoes;
	}

}
