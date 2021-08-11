package com.t2mTreinamento.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ColaboradoresEnderecosId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_colaborador")
	private Long idColaborador;

	@Column(name = "id_endereco")
	private Long idEndereco;

	public ColaboradoresEnderecosId() {

	}

	public ColaboradoresEnderecosId(Long idColaborador, Long idEndereco) {
		this.idColaborador = idColaborador;
		this.idEndereco = idEndereco;
	}

	public Long getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Long idColaborador) {
		this.idColaborador = idColaborador;
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idColaborador, idEndereco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColaboradoresEnderecosId other = (ColaboradoresEnderecosId) obj;
		return Objects.equals(idColaborador, other.idColaborador) && Objects.equals(idEndereco, other.idEndereco);
	}

}
