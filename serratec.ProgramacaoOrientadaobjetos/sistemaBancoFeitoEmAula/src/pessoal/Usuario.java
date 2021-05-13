package pessoal;

public abstract class Usuario {

	private String nome;
	private Integer id;
	private String tipo;
	private String cpf;
	private String senha;
	private Integer agencia;
	private Integer numeroConta;
	
	public Usuario() {
		super();
	}

	public Usuario(String tipo, String nome, Integer id, String cpf, String senha, Integer agencia, Integer numeroConta) {
		super();
		this.tipo = tipo;
		this.nome = nome;
		this.id = id;
		this.cpf = cpf;
		this.senha = senha;
		this.agencia = agencia;
		this.numeroConta = numeroConta;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getAgencia() {
		return agencia;
	}
	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}
	
	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	@Override
	public String toString() {
		return "Usuario\n\tnome=" + nome + ", \n\tid=" + id + ", \n\ttipo=" + tipo + ", \n\tcpf=" + cpf + ", \n\tsenha="
				+ senha + ", \n\tagencia=" + agencia;
	}
	
	
}
