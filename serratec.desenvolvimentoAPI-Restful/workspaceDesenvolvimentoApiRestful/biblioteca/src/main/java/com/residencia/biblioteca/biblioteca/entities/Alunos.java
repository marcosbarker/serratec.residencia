package com.residencia.biblioteca.biblioteca.entities;


import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="alunos")
public class Alunos {
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column (name = "numeromatriculaaluno")
		private int numeroMatriculaAluno;
		
		@Column (name = "nome")
		private String nome;
		
		@Column (name = "datanascimento")
		private Calendar dataDeNascimento;
		
		@Column (name = "cpf")
		private String cpf;
		
		@Column (name = "logradouro")
		private String longradouro;
		
		@Column (name = "numerologradouro")
		private String numeroLogradouro;
		
		@Column (name = "complemento")
		private String complemento;
		
		@Column (name = "bairro")
		private String bairro;
		
		@Column (name = "cidade")
		private String cidade;
		
		@OneToMany(mappedBy = "aluno")
		private List<Emprestimos> listEmprestimo;

				
		public int getNumeroMatriculaAluno() {
			return numeroMatriculaAluno;
		}


		public void setNumeroMatriculaAluno(int numeroMatriculaAluno) {
			this.numeroMatriculaAluno = numeroMatriculaAluno;
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}


		public Calendar getDataDeNascimento() {
			return dataDeNascimento;
		}


		public void setDataDeNascimento(Calendar dataDeNascimento) {
			this.dataDeNascimento = dataDeNascimento;
		}


		public String getCpf() {
			return cpf;
		}


		public void setCpf(String cpf) {
			this.cpf = cpf;
		}


		public String getLongradouro() {
			return longradouro;
		}


		public void setLongradouro(String longradouro) {
			this.longradouro = longradouro;
		}


		public String getNumeroLogradouro() {
			return numeroLogradouro;
		}


		public void setNumeroLogradouro(String numeroLogradouro) {
			this.numeroLogradouro = numeroLogradouro;
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


		public List<Emprestimos> getListEmprestimo() {
			return listEmprestimo;
		}


		public void setListEmprestimo(List<Emprestimos> listEmprestimo) {
			this.listEmprestimo = listEmprestimo;
		}
			
}
