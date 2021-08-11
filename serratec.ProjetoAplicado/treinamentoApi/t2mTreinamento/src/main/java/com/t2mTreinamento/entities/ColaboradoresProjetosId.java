package com.t2mTreinamento.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ColaboradoresProjetosId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_colaborador")
	private Long idColaborador;

	@Column(name = "id_projeto")
	private Long idProjeto;

	public ColaboradoresProjetosId() {
	}

	public ColaboradoresProjetosId(Long idColaborador, Long idProjeto) {
		this.idColaborador = idColaborador;
		this.idProjeto = idProjeto;
	}

	public Long getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Long idColaborador) {
		this.idColaborador = idColaborador;
	}

	public Long getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(Long idProjeto) {
		this.idProjeto = idProjeto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idColaborador, idProjeto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColaboradoresProjetosId other = (ColaboradoresProjetosId) obj;
		return Objects.equals(idColaborador, other.idColaborador) && Objects.equals(idProjeto, other.idProjeto);
	}

}
