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
@Table(name = "posicoes_competencias")
public class PosicoesCompetencias {

	@EmbeddedId
	private PosicoesCompetenciasId idPosicoesCompetencias;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idPosicao")
	@JsonIgnore
	@JoinColumn(name = "id_posicao")
	private Posicoes posicao;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idCompetencia")
	@JsonIgnore
	@JoinColumn(name = "id_competencia")
	private Competencias competencia;

	@Column(name = "isativo")
	private Integer isAtivo;

	public PosicoesCompetencias() {

	}

	public PosicoesCompetencias(PosicoesCompetenciasId idPosicoesCompetencias, Posicoes posicao,
			Competencias competencia, Integer isAtivo) {
		this.idPosicoesCompetencias = idPosicoesCompetencias;
		this.posicao = posicao;
		this.competencia = competencia;
		this.isAtivo = isAtivo;
	}

	public PosicoesCompetenciasId getIdPosicoesCompetencias() {
		return idPosicoesCompetencias;
	}

	public void setIdPosicoesCompetencias(PosicoesCompetenciasId idPosicoesCompetencias) {
		this.idPosicoesCompetencias = idPosicoesCompetencias;
	}

	public Posicoes getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicoes posicao) {
		this.posicao = posicao;
	}

	public Competencias getCompetencia() {
		return competencia;
	}

	public void setCompetencia(Competencias competencia) {
		this.competencia = competencia;
	}

	public Integer getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Integer isAtivo) {
		this.isAtivo = isAtivo;
	}

}
