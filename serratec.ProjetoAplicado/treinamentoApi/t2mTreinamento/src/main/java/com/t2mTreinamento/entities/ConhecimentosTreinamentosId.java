package com.t2mTreinamento.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ConhecimentosTreinamentosId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_conhecimento")
	private Long idConhecimento;

	@Column(name = "id_treinamento")
	private Long idTreinamento;

	public ConhecimentosTreinamentosId() {

	}

	public ConhecimentosTreinamentosId(Long idConhecimento, Long idTreinamento) {

		this.idConhecimento = idConhecimento;
		this.idTreinamento = idTreinamento;
	}

	public Long getIdConhecimento() {
		return idConhecimento;
	}

	public void setIdConhecimento(Long idConhecimento) {
		this.idConhecimento = idConhecimento;
	}

	public Long getIdTreinamento() {
		return idTreinamento;
	}

	public void setIdTreinamento(Long idTreinamento) {
		this.idTreinamento = idTreinamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idConhecimento, idTreinamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConhecimentosTreinamentosId other = (ConhecimentosTreinamentosId) obj;
		return Objects.equals(idConhecimento, other.idConhecimento)
				&& Objects.equals(idTreinamento, other.idTreinamento);
	}

}
