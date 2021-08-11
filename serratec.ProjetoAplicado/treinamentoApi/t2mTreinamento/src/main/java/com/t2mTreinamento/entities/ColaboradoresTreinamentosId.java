package com.t2mTreinamento.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ColaboradoresTreinamentosId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_colaborador")
	private Long idColaborador;

	@Column(name = "id_treinamento")
	private Long idTreinamento;

	public ColaboradoresTreinamentosId() {

	}

	public ColaboradoresTreinamentosId(Long idColaborador, Long idTreinamento) {
		this.idColaborador = idColaborador;
		this.idTreinamento = idTreinamento;
	}

	public Long getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Long idColaborador) {
		this.idColaborador = idColaborador;
	}

	public Long getIdTreinamento() {
		return idTreinamento;
	}

	public void setIdTreinamento(Long idTreinamento) {
		this.idTreinamento = idTreinamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idColaborador, idTreinamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColaboradoresTreinamentosId other = (ColaboradoresTreinamentosId) obj;
		return Objects.equals(idColaborador, other.idColaborador) && Objects.equals(idTreinamento, other.idTreinamento);
	}

}
