package com.t2mTreinamento.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ColaboradoresFormacoesId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_colaborador")
	private Long idColaborador;

	@Column(name = "id_formacao")
	private Long idFormacao;

	public ColaboradoresFormacoesId() {
	}

	public ColaboradoresFormacoesId(Long idColaborador, Long idFormacao) {
		this.idColaborador = idColaborador;
		this.idFormacao = idFormacao;
	}

	public Long getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Long idColaborador) {
		this.idColaborador = idColaborador;
	}

	public Long getIdFormacao() {
		return idFormacao;
	}

	public void setIdFormacao(Long idFormacao) {
		this.idFormacao = idFormacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idColaborador, idFormacao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColaboradoresFormacoesId other = (ColaboradoresFormacoesId) obj;
		return Objects.equals(idColaborador, other.idColaborador) && Objects.equals(idFormacao, other.idFormacao);
	}

}
