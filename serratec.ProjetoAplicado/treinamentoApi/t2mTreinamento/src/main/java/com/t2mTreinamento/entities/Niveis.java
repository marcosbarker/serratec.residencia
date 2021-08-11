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
import javax.validation.constraints.Size;

@Entity
@Table(name = "niveis")
public class Niveis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idNiveis;

	@Size(max = 50, message = "Nível excede o limite de {max} caracteres")
	@Column(name = "nivel")
	private String nivel;

	@Column(name = "isativo")
	private Integer isAtivo;

	@OneToMany(mappedBy = "nivel", cascade = CascadeType.ALL)
	private Set<CompetenciasNiveis> setCompetenciasNiveis;

	@OneToMany(mappedBy = "nivel", cascade = CascadeType.ALL)
	private Set<ConhecimentosNiveis> setConhecimentosNiveis;

	public Long getIdNiveis() {
		return idNiveis;
	}

	public void setIdNiveis(Long idNiveis) {
		this.idNiveis = idNiveis;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public Set<CompetenciasNiveis> getSetCompetenciasNiveis() {
		return setCompetenciasNiveis;
	}

	public void setSetCompetenciasNiveis(Set<CompetenciasNiveis> setCompetenciasNiveis) {
		this.setCompetenciasNiveis = setCompetenciasNiveis;
	}

	public Set<ConhecimentosNiveis> getSetConhecimentosNiveis() {
		return setConhecimentosNiveis;
	}

	public void setSetConhecimentosNiveis(Set<ConhecimentosNiveis> setConhecimentosNiveis) {
		this.setConhecimentosNiveis = setConhecimentosNiveis;
	}

	public Integer getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Integer isAtivo) {
		this.isAtivo = isAtivo;
	}

}
