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
@Table(name = "competencias_niveis")
public class CompetenciasNiveis {

	@EmbeddedId
	private CompetenciasNiveisId idCompetenciasNiveis;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idCompetencia")
	@JsonIgnore
	@JoinColumn(name = "id_competencia")
	private Competencias competencia;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idNivel")
	@JsonIgnore
	@JoinColumn(name = "id_nivel")
	private Niveis nivel;

	@Column(name = "isativo")
	private Integer isAtivo;

	public CompetenciasNiveis() {

	}

	public CompetenciasNiveis(CompetenciasNiveisId idCompetenciasNiveis, Competencias competencia, Niveis nivel,
			Integer isAtivo) {
		this.idCompetenciasNiveis = idCompetenciasNiveis;
		this.competencia = competencia;
		this.nivel = nivel;
		this.isAtivo = isAtivo;
	}

	public CompetenciasNiveisId getIdCompetenciasNiveis() {
		return idCompetenciasNiveis;
	}

	public void setIdCompetenciasNiveis(CompetenciasNiveisId idCompetenciasNiveis) {
		this.idCompetenciasNiveis = idCompetenciasNiveis;
	}

	public Competencias getCompetencia() {
		return competencia;
	}

	public void setCompetencia(Competencias competencia) {
		this.competencia = competencia;
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
