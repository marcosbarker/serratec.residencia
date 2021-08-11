package com.t2mTreinamento.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "conhecimentos")
public class Conhecimentos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idConhecimentos;

	@NotBlank
	@Size(min = 3, message = "Nome precisa ter no mínimo {min} caracteres")
	@Size(max = 25, message = "Nome excede o máximo de {max} caracteres")
	@Column(name = "nome")
	private String nome;

	@Size(max = 255, message = "Descrição excede o máximo de {max} caracteres")
	@Column(name = "descricao")
	private String descricao;

	@Column(name = "isativo")
	private Integer isAtivo;

	@OneToMany(mappedBy = "conhecimento", cascade = CascadeType.ALL)
	private Set<CompetenciasConhecimentos> setCompetenciasConhecimentos;

	@OneToMany(mappedBy = "conhecimento", cascade = CascadeType.ALL)
	private Set<ConhecimentosNiveis> setConhecimentosNiveis;

	@OneToMany(mappedBy = "conhecimento", cascade = CascadeType.ALL)
	private Set<ConhecimentosTreinamentos> setConhecimentosTreinamentos;

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

	public Set<CompetenciasConhecimentos> getSetCompetenciasConhecimentos() {
		return setCompetenciasConhecimentos;
	}

	public void setSetCompetenciasConhecimentos(Set<CompetenciasConhecimentos> setCompetenciasConhecimentos) {
		this.setCompetenciasConhecimentos = setCompetenciasConhecimentos;
	}

	public Set<ConhecimentosNiveis> getSetConhecimentosNiveis() {
		return setConhecimentosNiveis;
	}

	public void setSetConhecimentosNiveis(Set<ConhecimentosNiveis> setConhecimentosNiveis) {
		this.setConhecimentosNiveis = setConhecimentosNiveis;
	}

	public Set<ConhecimentosTreinamentos> getSetConhecimentosTreinamentos() {
		return setConhecimentosTreinamentos;
	}

	public void setSetConhecimentosTreinamentos(Set<ConhecimentosTreinamentos> setConhecimentosTreinamentos) {
		this.setConhecimentosTreinamentos = setConhecimentosTreinamentos;
	}

	public Integer getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Integer isAtivo) {
		this.isAtivo = isAtivo;
	}

}
