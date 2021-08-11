package com.t2mTreinamento.dtos;

import java.util.Set;

public class ConhecimentosDTO {
	private Long idConhecimentos;
	private String nome;
	private String descricao;
	private Set<ConhecimentosNiveisDTO> setConsNivs;
	private Set<ConhecimentosTreinamentosDTO> setConsTrns;

	public Long getIdConhecimentos() {
		return idConhecimentos;
	}

	public void setIdConhecimentos(Long idConhecimentos) {
		this.idConhecimentos = idConhecimentos;
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

	public Set<ConhecimentosNiveisDTO> getSetConsNivs() {
		return setConsNivs;
	}

	public void setSetConsNivs(Set<ConhecimentosNiveisDTO> setConsNivs) {
		this.setConsNivs = setConsNivs;
	}

	public Set<ConhecimentosTreinamentosDTO> getSetConsTrns() {
		return setConsTrns;
	}

	public void setSetConsTrns(Set<ConhecimentosTreinamentosDTO> setConsTrns) {
		this.setConsTrns = setConsTrns;
	}
}
