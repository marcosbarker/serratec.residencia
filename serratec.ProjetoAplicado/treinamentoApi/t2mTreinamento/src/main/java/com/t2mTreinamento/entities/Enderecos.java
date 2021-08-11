package com.t2mTreinamento.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "enderecos")
public class Enderecos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idEnderecos;

	@NotBlank
	@Size(min = 9, message = "CEP inválido")
	@Size(max = 9, message = "CEP inválido")
	@Column(name = "cep")
	private String cep;

	@Size(max = 100, message = "Rua excede o limite de {max} caracteres")
	@Column(name = "rua")
	private String rua;

	@Size(max = 10, message = "Número excede o limite de {max} caracteres")
	@Column(name = "numero")
	private String numero;

	@Size(max = 15, message = "Complemento excede o limite de {max} caracteres")
	@Column(name = "complemento")
	private String complemento;

	@Size(max = 50, message = "Bairro excede o limite de {max} caracteres")
	@Column(name = "bairro")
	private String bairro;

	@Size(max = 50, message = "Complemento excede o limite de {max} caracteres")
	@Column(name = "cidade")
	private String cidade;

	@Size(max = 2, message = "UF inválido")
	@Column(name = "estado")
	private String estado;

	@Size(max = 15, message = "País excede o limite de {max} caracteres")
	@Column(name = "pais")
	private String pais;

	@Column(name = "isativo")
	@JsonIgnore
	private Integer isAtivo;

	@OneToMany(mappedBy = "endereco", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<ColaboradoresEnderecos> setColaboradoresEnderecos;

	public Enderecos() {

	}

	public Enderecos(String cep, String rua, String numero, String complemento, String bairro, String cidade,
			String estado, String pais, Integer isAtivo) {
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.isAtivo = isAtivo;
	}

	public Long getIdEnderecos() {
		return idEnderecos;
	}

	public void setIdEnderecos(Long idEnderecos) {
		this.idEnderecos = idEnderecos;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Set<ColaboradoresEnderecos> getSetColaboradoresEnderecos() {
		return setColaboradoresEnderecos;
	}

	public void setSetColaboradoresEnderecos(Set<ColaboradoresEnderecos> setColaboradoresEnderecos) {
		this.setColaboradoresEnderecos = setColaboradoresEnderecos;
	}

	public Integer getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Integer isAtivo) {
		this.isAtivo = isAtivo;
	}

}
