package com.t2mTreinamento.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "certificacoes")
public class Certificacoes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idCertificacoes;

	@NotNull
	@Column(name = "tempo_validade")
	private Double tempoValidade;

	@Column(name = "isativo")
	private Integer isAtivo;

	@OneToOne
	@JoinColumn(name = "id_treinamento", referencedColumnName = "id")
	@JsonIgnore
	private Treinamentos treinamento;

	@OneToMany(mappedBy = "certificacao", cascade = CascadeType.ALL)
	private Set<ColaboradoresCertificacoes> setColaboradoresCertificacoes;

	public Long getIdCertificacoes() {
		return idCertificacoes;
	}

	public void setIdCertificacoes(Long idCertificacoes) {
		this.idCertificacoes = idCertificacoes;
	}

	public Double getTempoValidade() {
		return tempoValidade;
	}

	public void setTempoValidade(Double tempoValidade) {
		this.tempoValidade = tempoValidade;
	}

	public Treinamentos getTreinamento() {
		return treinamento;
	}

	public void setTreinamento(Treinamentos treinamento) {
		this.treinamento = treinamento;
	}

	public Set<ColaboradoresCertificacoes> getSetColaboradoresCertificacoes() {
		return setColaboradoresCertificacoes;
	}

	public void setSetColaboradoresCertificacoes(Set<ColaboradoresCertificacoes> setColaboradoresCertificacoes) {
		this.setColaboradoresCertificacoes = setColaboradoresCertificacoes;
	}

	public Integer getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Integer isAtivo) {
		this.isAtivo = isAtivo;
	}

}
