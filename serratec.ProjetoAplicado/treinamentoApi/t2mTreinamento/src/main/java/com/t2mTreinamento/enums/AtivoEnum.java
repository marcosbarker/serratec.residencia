package com.t2mTreinamento.enums;

public enum AtivoEnum {

	INATIVO(0), ATIVO(1);

	private final Integer statusAtivo;

	AtivoEnum(Integer statusAtivo) {
		this.statusAtivo = statusAtivo;
	}

	public Integer getStatusAtivo() {
		return this.statusAtivo;
	}
}
