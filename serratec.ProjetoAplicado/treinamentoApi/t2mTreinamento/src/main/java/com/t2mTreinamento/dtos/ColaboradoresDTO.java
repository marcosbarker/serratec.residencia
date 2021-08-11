package com.t2mTreinamento.dtos;

import java.util.Calendar;
import java.util.Set;

public class ColaboradoresDTO {
	private Long idColaboradores;
	private String nome;
	private Calendar dataNascimento;
	private String email;
	private String pix;
	private String cpf;
	private String rg;
	private String cnh;
	private Integer permissao;
	private PosicoesDTO posicao;
	private UsuariosDTO usuario;
	private Set<ColaboradoresEnderecosDTO> setColabsEndrs;
	private Set<ColaboradoresProjetosDTO> setColabsProjs;
	private Set<ColaboradoresFormacoesDTO> setColabsForms;
	private Set<ColaboradoresTreinamentosDTO> setColabsTrns;
	private Set<ColaboradoresCertificacoesDTO> setColabsCerts;

	public ColaboradoresDTO() {

	}

	public ColaboradoresDTO(Long idColaboradores, String nome, Calendar dataNascimento, String email, String pix,
			String cpf, String rg, String cnh, Integer permissao) {
		this.idColaboradores = idColaboradores;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.pix = pix;
		this.cpf = cpf;
		this.rg = rg;
		this.cnh = cnh;
		this.permissao = permissao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Integer getPermissao() {
		return permissao;
	}

	public void setPermissao(Integer permissao) {
		this.permissao = permissao;
	}

	public Set<ColaboradoresEnderecosDTO> getSetColabsEndrs() {
		return setColabsEndrs;
	}

	public void setSetColabsEndrs(Set<ColaboradoresEnderecosDTO> setColabsEndrs) {
		this.setColabsEndrs = setColabsEndrs;
	}

	public Set<ColaboradoresProjetosDTO> getSetColabsProjs() {
		return setColabsProjs;
	}

	public void setSetColabsProjs(Set<ColaboradoresProjetosDTO> setColabsProjs) {
		this.setColabsProjs = setColabsProjs;
	}

	public Set<ColaboradoresFormacoesDTO> getSetColabsForms() {
		return setColabsForms;
	}

	public void setSetColabsForms(Set<ColaboradoresFormacoesDTO> setColabsForms) {
		this.setColabsForms = setColabsForms;
	}

	public Set<ColaboradoresTreinamentosDTO> getSetColabsTrns() {
		return setColabsTrns;
	}

	public void setSetColabsTrns(Set<ColaboradoresTreinamentosDTO> setColabsTrns) {
		this.setColabsTrns = setColabsTrns;
	}

	public Set<ColaboradoresCertificacoesDTO> getSetColabsCerts() {
		return setColabsCerts;
	}

	public void setSetColabsCerts(Set<ColaboradoresCertificacoesDTO> setColabsCerts) {
		this.setColabsCerts = setColabsCerts;
	}

	public PosicoesDTO getPosicao() {
		return posicao;
	}

	public void setPosicao(PosicoesDTO posicao) {
		this.posicao = posicao;
	}

	public Long getIdColaboradores() {
		return idColaboradores;
	}

	public void setIdColaboradores(Long idColaboradores) {
		this.idColaboradores = idColaboradores;
	}

	public UsuariosDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuariosDTO usuario) {
		this.usuario = usuario;
	}

}
