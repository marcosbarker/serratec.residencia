package com.t2mTreinamento.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ErroResposta {

	private Integer status;
	private String titulo;
	private List<String> erros;
	private LocalDateTime dataHora;

	public ErroResposta(Integer status, String titulo, LocalDateTime dataHora, List<String> erros) {
		this.status = status;
		this.titulo = titulo;
		this.erros = erros;
		this.dataHora = dataHora;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDateTime getDataHora() {
		return this.dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

}
