package com.t2mTreinamento.dtos;

import java.util.Set;

public class CompetenciasDTO {
	private Long idCompetencias;
	private String nome;
	private String descricao;
	private Set<CompetenciasNiveisDTO> setCompsNivs;
	private Set<CompetenciasConhecimentosDTO> setCompsCons;

	public Long getIdCompetencias() {
		return idCompetencias;
	}

	public void setIdCompetencias(Long idCompetencias) {
		this.idCompetencias = idCompetencias;
	}

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

	public Set<CompetenciasNiveisDTO> getSetCompsNivs() {
		return setCompsNivs;
	}

	public void setSetCompsNivs(Set<CompetenciasNiveisDTO> setCompsNivs) {
		this.setCompsNivs = setCompsNivs;
	}

	public Set<CompetenciasConhecimentosDTO> getSetCompsCons() {
		return setCompsCons;
	}

	public void setSetCompsCons(Set<CompetenciasConhecimentosDTO> setCompsCons) {
		this.setCompsCons = setCompsCons;
	}

}
