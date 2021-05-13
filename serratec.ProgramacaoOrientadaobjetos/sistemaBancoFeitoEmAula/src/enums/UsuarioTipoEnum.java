package enums;

public enum UsuarioTipoEnum {
	PRESIDENTE("presidente", 1),
	GERENTE("gerente", 2),
	DIRETOR("diretor", 3),
	CLIENTE("cliente", 4);
	
	private final String tipo;
	private final int id;
	

	UsuarioTipoEnum(String tipo, Integer id) {
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

