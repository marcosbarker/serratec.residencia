package com.t2mTreinamento.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuarios")
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idUsuarios;

	@NotBlank
	@Size(max = 20, message = "Usuário excede o limite de {max} caracteres")
	@Column(name = "usuario")
	private String usuario;

	@NotBlank
	@Size(max = 8, message = "Senha excede o limite de {max} caracteres")
	@Column(name = "senha")
	private String senha;

	@Column(name = "isadmin")
	private Integer isAdmin;

	@Column(name = "isativo")
	private Integer isAtivo;

	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "id_colaborador", referencedColumnName = "id")
	private Colaboradores colaborador;

	public Usuarios() {

	}

	public Usuarios(String usuario, String senha, Integer isAdmin, Integer isAtivo, Colaboradores colaborador) {
		this.usuario = usuario;
		this.senha = senha;
		this.isAdmin = isAdmin;
		this.isAtivo = isAtivo;
		this.colaborador = colaborador;
	}

	public Long getIdUsuarios() {
		return idUsuarios;
	}

	public void setIdUsuarios(Long idUsuarios) {
		this.idUsuarios = idUsuarios;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Colaboradores getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaboradores colaborador) {
		this.colaborador = colaborador;
	}

	public Integer getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Integer isAtivo) {
		this.isAtivo = isAtivo;
	}

}
