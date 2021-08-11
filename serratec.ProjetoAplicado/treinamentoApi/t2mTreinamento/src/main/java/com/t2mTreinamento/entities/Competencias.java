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
@Table(name = "competencias")
public class Competencias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idCompetencias;

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

	@OneToMany(mappedBy = "competencia", cascade = CascadeType.ALL)
	private Set<PosicoesCompetencias> setPosicoesCompetencias;

	@OneToMany(mappedBy = "competencia", cascade = CascadeType.ALL)
	private Set<CompetenciasNiveis> setCompetenciasNiveis;

	@OneToMany(mappedBy = "competencia", cascade = CascadeType.ALL)
	private Set<CompetenciasConhecimentos> setCompetenciasConhecimentos;

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

	public Set<PosicoesCompetencias> getSetPosicoesCompetencias() {
		return setPosicoesCompetencias;
	}

	public void setSetPosicoesCompetencias(Set<PosicoesCompetencias> setPosicoesCompetencias) {
		this.setPosicoesCompetencias = setPosicoesCompetencias;
	}

	public Set<CompetenciasNiveis> getSetCompetenciasNiveis() {
		return setCompetenciasNiveis;
	}

	public void setSetCompetenciasNiveis(Set<CompetenciasNiveis> setCompetenciasNiveis) {
		this.setCompetenciasNiveis = setCompetenciasNiveis;
	}

	public Set<CompetenciasConhecimentos> getSetCompetenciasConhecimentos() {
		return setCompetenciasConhecimentos;
	}

	public void setSetCompetenciasConhecimentos(Set<CompetenciasConhecimentos> setCompetenciasConhecimentos) {
		this.setCompetenciasConhecimentos = setCompetenciasConhecimentos;
	}

	public Integer getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Integer isAtivo) {
		this.isAtivo = isAtivo;
	}

}
