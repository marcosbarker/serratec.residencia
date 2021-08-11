package com.t2mTreinamento.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CompetenciasNiveisId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_competencia")
	private Long idCompetencia;

	@Column(name = "id_nivel")
	private Long idNivel;

	public CompetenciasNiveisId() {

	}

	public CompetenciasNiveisId(Long idCompetencia, Long idNivel) {

		this.idCompetencia = idCompetencia;
		this.idNivel = idNivel;
	}

	public Long getIdCompetencia() {
		return idCompetencia;
	}

	public void setIdCompetencia(Long idCompetencia) {
		this.idCompetencia = idCompetencia;
	}

	public Long getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(Long idNivel) {
		this.idNivel = idNivel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCompetencia, idNivel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompetenciasNiveisId other = (CompetenciasNiveisId) obj;
		return Objects.equals(idCompetencia, other.idCompetencia) && Objects.equals(idNivel, other.idNivel);
	}

}
