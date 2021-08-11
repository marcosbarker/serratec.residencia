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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "posicoes")
public class Posicoes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idPosicoes;

	@NotBlank
	@Size(min = 3, message = "O nome precisa ter um mínimo de {min} caracteres")
	@Size(max = 50, message = "O nome excede o limite de {max} caracteres")
	@Column(name = "nome")
	private String nome;

	@Size(max = 255, message = "Descrição excede o limite de {max} caracteres")
	@Column(name = "descricao")
	private String descricao;

	@Column(name = "isativo")
	private Integer isAtivo;

	@OneToMany(mappedBy = "posicao", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Colaboradores> setColaboradores;

	@OneToMany(mappedBy = "posicao", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<PosicoesCompetencias> setPosicoesCompetencias;

	public Long getIdPosicoes() {
		return idPosicoes;
	}

	public void setIdPosicoes(Long idPosicoes) {
		this.idPosicoes = idPosicoes;
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

	public Integer getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Integer isAtivo) {
		this.isAtivo = isAtivo;
	}

	public Set<Colaboradores> getSetColaboradores() {
		return setColaboradores;
	}

	public void setSetColaboradores(Set<Colaboradores> setColaboradores) {
		this.setColaboradores = setColaboradores;
	}

}
