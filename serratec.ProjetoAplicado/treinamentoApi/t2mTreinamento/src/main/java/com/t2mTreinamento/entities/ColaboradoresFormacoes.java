package com.t2mTreinamento.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "colaboradores_formacoes")
public class ColaboradoresFormacoes {

	@EmbeddedId
	private ColaboradoresFormacoesId idColaboradoresFormacoes;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idColaborador")
	@JsonIgnore
	@JoinColumn(name = "id_colaborador")
	private Colaboradores colaborador;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idFormacao")
	@JsonIgnore
	@JoinColumn(name = "id_formacao")
	private Formacoes formacao;

	@NotNull
	@Column(name = "data_entrada")
	private Calendar dataEntrada;

	@Column(name = "data_conclusao")
	private Calendar dataConclusao;

	@Column(name = "isativo")
	@JsonIgnore
	private Integer isAtivo;

	public ColaboradoresFormacoes() {

	}

	public ColaboradoresFormacoes(ColaboradoresFormacoesId idColaboradoresFormacoes, Colaboradores colaborador,
			Formacoes formacao, Calendar dataEntrada, Integer isAtivo) {
		this.idColaboradoresFormacoes = idColaboradoresFormacoes;
		this.colaborador = colaborador;
		this.formacao = formacao;
		this.dataEntrada = dataEntrada;
		this.isAtivo = isAtivo;
	}

	public ColaboradoresFormacoes(ColaboradoresFormacoesId idColaboradoresFormacoes, Colaboradores colaborador,
			Formacoes formacao, Calendar dataEntrada, Calendar dataConclusao, Integer isAtivo) {
		this.idColaboradoresFormacoes = idColaboradoresFormacoes;
		this.colaborador = colaborador;
		this.formacao = formacao;
		this.dataEntrada = dataEntrada;
		this.dataConclusao = dataConclusao;
		this.isAtivo = isAtivo;
	}

	public ColaboradoresFormacoesId getIdColaboradoresFormacoes() {
		return idColaboradoresFormacoes;
	}

	public void setIdColaboradoresFormacoes(ColaboradoresFormacoesId idColaboradoresFormacoes) {
		this.idColaboradoresFormacoes = idColaboradoresFormacoes;
	}

	public Colaboradores getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaboradores colaborador) {
		this.colaborador = colaborador;
	}

	public Formacoes getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacoes formacao) {
		this.formacao = formacao;
	}

	public Calendar getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Calendar getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(Calendar dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public Integer getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Integer isAtivo) {
		this.isAtivo = isAtivo;
	}

}
