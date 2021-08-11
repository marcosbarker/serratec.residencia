package com.t2mTreinamento.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CompetenciasConhecimentosId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_competencia")
	private Long idCompetencia;

	@Column(name = "id_conhecimento")
	private Long idConhecimento;

	public CompetenciasConhecimentosId() {

	}

	public CompetenciasConhecimentosId(Long idCompetencia, Long idConhecimento) {
		this.idCompetencia = idCompetencia;
		this.idConhecimento = idConhecimento;
	}

	public Long getIdCompetencia() {
		return idCompetencia;
	}

	public void setIdCompetencia(Long idCompetencia) {
		this.idCompetencia = idCompetencia;
	}

	public Long getIdConhecimento() {
		return idConhecimento;
	}

	public void setIdConhecimento(Long idConhecimento) {
		this.idConhecimento = idConhecimento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCompetencia, idConhecimento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompetenciasConhecimentosId other = (CompetenciasConhecimentosId) obj;
		return Objects.equals(idCompetencia, other.idCompetencia)
				&& Objects.equals(idConhecimento, other.idConhecimento);
	}

}
