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
@Table(name = "conhecimentos_niveis")
public class ConhecimentosNiveis {

	@EmbeddedId
	private ConhecimentosNiveisId idConhecimentosNiveis;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idConhecimento")
	@JsonIgnore
	@JoinColumn(name = "id_conhecimento")
	private Conhecimentos conhecimento;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idNivel")
	@JsonIgnore
	@JoinColumn(name = "id_nivel")
	private Niveis nivel;

	@Column(name = "isativo")
	private Integer isAtivo;

	public ConhecimentosNiveis() {

	}

	public ConhecimentosNiveis(ConhecimentosNiveisId idConhecimentosNiveis, Conhecimentos conhecimento, Niveis nivel,
			Integer isAtivo) {

		this.idConhecimentosNiveis = idConhecimentosNiveis;
		this.conhecimento = conhecimento;
		this.nivel = nivel;
		this.isAtivo = isAtivo;
	}

	public ConhecimentosNiveisId getIdConhecimentosNiveis() {
		return idConhecimentosNiveis;
	}

	public void setIdConhecimentosNiveis(ConhecimentosNiveisId idConhecimentosNiveis) {
		this.idConhecimentosNiveis = idConhecimentosNiveis;
	}

	public Conhecimentos getConhecimento() {
		return conhecimento;
	}

	public void setConhecimento(Conhecimentos conhecimento) {
		this.conhecimento = conhecimento;
	}

	public Niveis getNivel() {
		return nivel;
	}

	public void setNivel(Niveis nivel) {
		this.nivel = nivel;
	}

	public Integer getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Integer isAtivo) {
		this.isAtivo = isAtivo;
	}

}
