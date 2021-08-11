package com.t2mTreinamento.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "conhecimentos_treinamentos")
public class ConhecimentosTreinamentos {

	@EmbeddedId
	private ConhecimentosTreinamentosId idConhecimentosTreinamentos;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idConhecimento")
	@JsonIgnore
	@JoinColumn(name = "id_conhecimento")
	private Conhecimentos conhecimento;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idTreinamento")
	@JsonIgnore
	@JoinColumn(name = "id_treinamento")
	private Treinamentos treinamento;

	@Column(name = "isativo")
	private Integer isAtivo;

	public ConhecimentosTreinamentos() {

	}

	public ConhecimentosTreinamentos(ConhecimentosTreinamentosId idConhecimentosTreinamentos,
			Conhecimentos conhecimento, Treinamentos treinamento, Integer isAtivo) {
		this.idConhecimentosTreinamentos = idConhecimentosTreinamentos;
		this.conhecimento = conhecimento;
		this.treinamento = treinamento;
		this.isAtivo = isAtivo;
	}

	public ConhecimentosTreinamentosId getIdConhecimentosTreinamentos() {
		return idConhecimentosTreinamentos;
	}

	public void setIdConhecimentosTreinamentos(ConhecimentosTreinamentosId idConhecimentosTreinamentos) {
		this.idConhecimentosTreinamentos = idConhecimentosTreinamentos;
	}

	public Conhecimentos getConhecimento() {
		return conhecimento;
	}

	public void setConhecimento(Conhecimentos conhecimento) {
		this.conhecimento = conhecimento;
	}

	public Treinamentos getTreinamento() {
		return treinamento;
	}

	public void setTreinamento(Treinamentos treinamento) {
		this.treinamento = treinamento;
	}

	public Integer getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Integer isAtivo) {
		this.isAtivo = isAtivo;
	}

}
