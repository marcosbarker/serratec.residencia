package com.t2mTreinamento.entities;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "colaboradores")
public class Colaboradores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idColaboradores;

	@NotBlank
	@Size(min = 3, message = "O nome precisa ter um mínimo de {min} caracteres")
	@Size(max = 50, message = "O nome excede o limite de {max} caracteres")
	@Column(name = "nome")
	private String nome;

	@Column(name = "data_nascimento")
	private Calendar dataNascimento;

	@Email(message = "E-mail fornecido não é válido")
	@Pattern(regexp = ".+@.+\\..+", message = "E-mail fornecido não é válido")
	@Column(name = "email")
	private String email;

	@Column(name = "pix", unique = true)
	private String pix;

	@NotBlank
	@Size(min = 14, message = "Formato de CPF inválido")
	@Size(max = 14, message = "Formato de CPF inválido")
//	@Pattern(regexp = "/^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$/", message = "CPF inválido")
	@Column(name = "cpf", unique = true)
	private String cpf;

	@NotBlank
	@Size(min = 12, message = "Formato de RG inválido")
	@Size(max = 12, message = "Formato de RG inválido")
	@Column(name = "rg", unique = true)
	private String rg;

	@NotBlank
	@Column(name = "cnh")
	private String cnh;

	@NotNull
	@Column(name = "permissao")
	private Integer permissao;

	@Column(name = "isativo")
	private Integer isAtivo;

	@OneToOne(mappedBy = "colaborador", cascade = CascadeType.ALL)
	private Usuarios usuario;

	@ManyToOne
	@JoinColumn(name = "id_posicao", referencedColumnName = "id")
	private Posicoes posicao;

	@OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL)
	private Set<ColaboradoresEnderecos> setColaboradoresEnderecos;

	@OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL)
	private Set<ColaboradoresProjetos> setColaboradoresProjetos;

	@OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL)
	private Set<ColaboradoresFormacoes> setColaboradoresFormacoes;

	@OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL)
	private Set<ColaboradoresTreinamentos> setColaboradoresTreinamentos;

	@OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL)
	private Set<ColaboradoresCertificacoes> setColaboradoresCertificacoes;

	public Colaboradores() {

	}

	public Colaboradores(String nome, Calendar dataNascimento, String email, String pix, String cpf, String rg,
			String cnh, Integer permissao) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.pix = pix;
		this.cpf = cpf;
		this.rg = rg;
		this.cnh = cnh;
		this.permissao = permissao;
	}

	public Colaboradores(String nome, Calendar dataNascimento, String email, String pix, String cpf, String rg,
			String cnh, Integer permissao, Integer isAtivo) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.pix = pix;
		this.cpf = cpf;
		this.rg = rg;
		this.cnh = cnh;
		this.permissao = permissao;
		this.isAtivo = isAtivo;
	}

	public Long getIdColaboradores() {
		return idColaboradores;
	}

	public void setIdColaboradores(Long idColaboradores) {
		this.idColaboradores = idColaboradores;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPix() {
		return pix;
	}

	public void setPix(String pix) {
		this.pix = pix;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Posicoes getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicoes posicao) {
		this.posicao = posicao;
	}

	public Set<ColaboradoresEnderecos> getSetColaboradoresEnderecos() {
		return setColaboradoresEnderecos;
	}

	public void setSetColaboradoresEnderecos(Set<ColaboradoresEnderecos> setColaboradoresEnderecos) {
		this.setColaboradoresEnderecos = setColaboradoresEnderecos;
	}

	public Set<ColaboradoresProjetos> getSetColaboradoresProjetos() {
		return setColaboradoresProjetos;
	}

	public void setSetColaboradoresProjetos(Set<ColaboradoresProjetos> setColaboradoresProjetos) {
		this.setColaboradoresProjetos = setColaboradoresProjetos;
	}

	public Set<ColaboradoresFormacoes> getSetColaboradoresFormacoes() {
		return setColaboradoresFormacoes;
	}

	public void setSetColaboradoresFormacoes(Set<ColaboradoresFormacoes> setColaboradoresFormacoes) {
		this.setColaboradoresFormacoes = setColaboradoresFormacoes;
	}

	public Set<ColaboradoresTreinamentos> getSetColaboradoresTreinamentos() {
		return setColaboradoresTreinamentos;
	}

	public void setSetColaboradoresTreinamentos(Set<ColaboradoresTreinamentos> setColaboradoresTreinamentos) {
		this.setColaboradoresTreinamentos = setColaboradoresTreinamentos;
	}

	public Set<ColaboradoresCertificacoes> getSetColaboradoresCertificacoes() {
		return setColaboradoresCertificacoes;
	}

	public void setSetColaboradoresCertificacoes(Set<ColaboradoresCertificacoes> setColaboradoresCertificacoes) {
		this.setColaboradoresCertificacoes = setColaboradoresCertificacoes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Integer isAtivo) {
		this.isAtivo = isAtivo;
	}

	public Integer getPermissao() {
		return permissao;
	}

	public void setPermissao(Integer permissao) {
		this.permissao = permissao;
	}

}
