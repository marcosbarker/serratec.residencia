package com.t2mTreinamento.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ConhecimentosNiveisId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_conhecimento")
	private Long idConhecimento;

	@Column(name = "id_nivel")
	private Long idNivel;

	public ConhecimentosNiveisId() {

	}

	public ConhecimentosNiveisId(Long idConhecimento, Long idNivel) {
		this.idConhecimento = idConhecimento;
		this.idNivel = idNivel;
	}

	public Long getIdConhecimento() {
		return idConhecimento;
	}

	public void setIdConhecimento(Long idConhecimento) {
		this.idConhecimento = idConhecimento;
	}

	public Long getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(Long idNivel) {
		this.idNivel = idNivel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idConhecimento, idNivel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConhecimentosNiveisId other = (ConhecimentosNiveisId) obj;
		return Objects.equals(idConhecimento, other.idConhecimento) && Objects.equals(idNivel, other.idNivel);
	}

}
