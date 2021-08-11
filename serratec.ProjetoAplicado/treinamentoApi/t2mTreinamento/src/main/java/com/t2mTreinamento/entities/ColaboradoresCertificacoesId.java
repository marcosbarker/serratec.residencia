package com.t2mTreinamento.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ColaboradoresCertificacoesId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_colaborador")
	private Long idColaborador;

	@Column(name = "id_certificacao")
	private Long idCertificacao;

	public ColaboradoresCertificacoesId() {

	}

	public ColaboradoresCertificacoesId(Long idColaborador, Long idCertificacao) {
		this.idColaborador = idColaborador;
		this.idCertificacao = idCertificacao;
	}

	public Long getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Long idColaborador) {
		this.idColaborador = idColaborador;
	}

	public Long getIdCertificacao() {
		return idCertificacao;
	}

	public void setIdCertificacao(Long idCertificacao) {
		this.idCertificacao = idCertificacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCertificacao, idColaborador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColaboradoresCertificacoesId other = (ColaboradoresCertificacoesId) obj;
		return Objects.equals(idCertificacao, other.idCertificacao)
				&& Objects.equals(idColaborador, other.idColaborador);
	}

}
