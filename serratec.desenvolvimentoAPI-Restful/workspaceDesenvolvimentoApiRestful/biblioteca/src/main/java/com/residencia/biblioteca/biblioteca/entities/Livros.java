package com.residencia.biblioteca.biblioteca.entities;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="livros")
public class Livros {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "codigolivro")
	private Integer  codigoLivro;
	
	@Column (name = "nomelivro")
	private String nomeLivro;
	
	@Column (name = "nomeautor")
	private String nomeAutor;
	
	@Column (name = "datalancamento")
	private Calendar dataLancamento;
	
	@Column (name = "codigoisbn")
	private int codigoIsBn;
	
	@JsonIgnore
	@OneToMany(mappedBy = "livro")
	private List<Emprestimos> listLivrosEmprestimo;
		
	@OneToOne
	@JoinColumn(name = "codigoeditora", referencedColumnName = "codigoeditora")
	private Editoras editora;
	
	//UM OU MUITOS LIVROS PODE TER UMA EDITORA 
	
	
	public Integer getCodigoLivro() {
		return codigoLivro;
	}

	public void setCodigoLivro(Integer codigoLivro) {
		this.codigoLivro = codigoLivro;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public int getCodigoIsBn() {
		return codigoIsBn;
	}

	public void setCodigoIsBn(int codigoIsBn) {
		this.codigoIsBn = codigoIsBn;
	}

	public List<Emprestimos> getListLivrosEmprestimo() {
		return listLivrosEmprestimo;
	}

	public void setListLivrosEmprestimo(List<Emprestimos> listLivrosEmprestimo) {
		this.listLivrosEmprestimo = listLivrosEmprestimo;
	}

	public Editoras getEditora() {
		return editora;
	}

	public void setEditora(Editoras editora) {
		this.editora = editora;
	}
	
	
	
	
}
