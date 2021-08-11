package com.t2mTreinamento.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PosicoesCompetenciasId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_posicao")
	private Long idPosicao;

	@Column(name = "id_competencia")
	private Long idCompetencia;

	public PosicoesCompetenciasId() {
	}

	public PosicoesCompetenciasId(Long idPosicao, Long idCompetencia) {
		this.idPosicao = idPosicao;
		this.idCompetencia = idCompetencia;
	}

	public Long getIdPosicao() {
		return idPosicao;
	}

	public void setIdPosicao(Long idPosicao) {
		this.idPosicao = idPosicao;
	}

	public Long getIdCompetencia() {
		return idCompetencia;
	}

	public void setIdCompetencia(Long idCompetencia) {
		this.idCompetencia = idCompetencia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCompetencia, idPosicao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PosicoesCompetenciasId other = (PosicoesCompetenciasId) obj;
		return Objects.equals(idCompetencia, other.idCompetencia) && Objects.equals(idPosicao, other.idPosicao);
	}

}
