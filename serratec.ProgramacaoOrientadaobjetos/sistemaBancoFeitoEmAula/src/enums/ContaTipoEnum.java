package enums;

public enum ContaTipoEnum {
	CORRENTE("corrente", 1),
	POUPANCA("poupanca", 2);
	
	private final String tipo;
	private final int id;

	ContaTipoEnum(String tipo, Integer id) {
		this.tipo = tipo;
		this.id = id;
	}

	public String getTipo() {
		return this.tipo;
	}
	public int getId() {
		return this.id;
	}
	
}
