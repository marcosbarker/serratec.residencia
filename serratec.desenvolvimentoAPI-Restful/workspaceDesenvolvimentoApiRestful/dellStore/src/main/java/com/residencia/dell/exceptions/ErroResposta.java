package com.residencia.dell.exceptions;

import java.time.LocalDateTime;
import java.util.List;

public class ErroResposta {
	
	private Integer status;
	private String titulo;
	private LocalDateTime dataHora;
	private List<String> listError;
 
	public ErroResposta(Integer status, String titulo, LocalDateTime dataHora, List<String> listError) {
		this.status = status;
		this.titulo = titulo;
		this.dataHora = dataHora;
		this.listError = listError;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public List<String> getListError() {
		return listError;
	}

	public void setListError(List<String> listError) {
		this.listError = listError;
	}

}