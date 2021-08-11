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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "colaboradores_projetos")
public class ColaboradoresProjetos {

	@EmbeddedId
	private ColaboradoresProjetosId idColaboradoresProjetos;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idColaborador")
	@JsonIgnore
	@JoinColumn(name = "id_colaborador")
	private Colaboradores colaborador;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idProjeto")
	@JsonIgnore
	@JoinColumn(name = "id_projeto")
	private Projetos projeto;

	@NotBlank
	@Size(min = 3, message = "A função precisa ter no mínimo {min} caracteres")
	@Size(max = 50, message = "A função excede o máximo de {max} caracteres")
	@Column(name = "funcao")
	private String funcao;

	@NotNull
	@Column(name = "data_inicio")
	private Calendar dataInicio;

	@Column(name = "data_saida")
	private Calendar dataSaida;

	@Column(name = "isativo")
	@JsonIgnore
	private Integer isAtivo;

	public ColaboradoresProjetos() {

	}

	public ColaboradoresProjetos(ColaboradoresProjetosId idColaboradoresProjetos, Colaboradores colaborador,
			Projetos projeto, String funcao, Calendar dataInicio, Integer isAtivo) {
		this.idColaboradoresProjetos = idColaboradoresProjetos;
		this.colaborador = colaborador;
		this.projeto = projeto;
		this.funcao = funcao;
		this.dataInicio = dataInicio;
		this.isAtivo = isAtivo;
	}

	public ColaboradoresProjetos(ColaboradoresProjetosId idColaboradoresProjetos, Colaboradores colaborador,
			Projetos projeto, String funcao, Calendar dataInicio, Calendar dataSaida, Integer isAtivo) {
		this.idColaboradoresProjetos = idColaboradoresProjetos;
		this.colaborador = colaborador;
		this.projeto = projeto;
		this.funcao = funcao;
		this.dataInicio = dataInicio;
		this.dataSaida = dataSaida;
		this.isAtivo = isAtivo;
	}

	public ColaboradoresProjetosId getIdColaboradoresProjetos() {
		return idColaboradoresProjetos;
	}

	public void setIdColaboradoresProjetos(ColaboradoresProjetosId idColaboradoresProjetos) {
		this.idColaboradoresProjetos = idColaboradoresProjetos;
	}

	public Colaboradores getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaboradores colaborador) {
		this.colaborador = colaborador;
	}

	public Projetos getProjeto() {
		return projeto;
	}

	public void setProjeto(Projetos projeto) {
		this.projeto = projeto;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Calendar dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Integer getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Integer isAtivo) {
		this.isAtivo = isAtivo;
	}

}
