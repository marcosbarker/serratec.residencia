package com.t2mTreinamento.dtos;

public class TreinamentosDTO {
	private Long idTreinamentos;
	private String nome;
	private String instituicao;
	private Double cargaHoraria;
	private String descricao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public Double getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Double cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getIdTreinamentos() {
		return idTreinamentos;
	}

	public void setIdTreinamentos(Long idTreinamentos) {
		this.idTreinamentos = idTreinamentos;
	}

}
