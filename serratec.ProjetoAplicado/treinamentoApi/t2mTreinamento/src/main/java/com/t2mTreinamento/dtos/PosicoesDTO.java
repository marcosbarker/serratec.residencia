package com.t2mTreinamento.dtos;

import java.util.Set;

public class PosicoesDTO {
	private Long idPosicoes;
	private String nome;
	private String descricao;
	private Set<PosicoesCompetenciasDTO> setPosComps;

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

	public Long getIdPosicoes() {
		return idPosicoes;
	}

	public void setIdPosicoes(Long idPosicoes) {
		this.idPosicoes = idPosicoes;
	}

	public Set<PosicoesCompetenciasDTO> getSetPosComps() {
		return setPosComps;
	}

	public void setSetPosComps(Set<PosicoesCompetenciasDTO> setPosComps) {
		this.setPosComps = setPosComps;
	}

}
