package com.t2mTreinamento.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "colaboradores_enderecos")
public class ColaboradoresEnderecos {
	@EmbeddedId
	private ColaboradoresEnderecosId idColaboradoresEnderecos;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idColaborador")
	@JsonIgnore
	@JoinColumn(name = "id_colaborador")
	private Colaboradores colaborador;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idEndereco")
	@JsonIgnore
	@JoinColumn(name = "id_endereco")
	private Enderecos endereco;

	@Column(name = "isativo")
	@JsonIgnore
	private Integer isAtivo;

	public ColaboradoresEnderecos() {

	}

	public ColaboradoresEnderecos(ColaboradoresEnderecosId idColaboradoresEnderecos, Colaboradores colaborador,
			Enderecos endereco, Integer isAtivo) {

		this.idColaboradoresEnderecos = idColaboradoresEnderecos;
		this.colaborador = colaborador;
		this.endereco = endereco;
		this.isAtivo = isAtivo;
	}

	public ColaboradoresEnderecosId getIdColaboradoresEnderecos() {
		return idColaboradoresEnderecos;
	}

	public void setIdColaboradoresEnderecos(ColaboradoresEnderecosId idColaboradoresEnderecos) {
		this.idColaboradoresEnderecos = idColaboradoresEnderecos;
	}

	public Colaboradores getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaboradores colaborador) {
		this.colaborador = colaborador;
	}

	public Enderecos getEndereco() {
		return endereco;
	}

	public void setEndereco(Enderecos endereco) {
		this.endereco = endereco;
	}

	public Integer getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Integer isAtivo) {
		this.isAtivo = isAtivo;
	}

}
