package funcionario;
import usuario.Cliente;


public abstract class Funcionario extends Cliente{

	public Funcionario() {
		
	}

	public Funcionario(String nome, int senha, int cpf, String cargo) {
		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;
		this.cargo = cargo;
		
	}

	public String getCargo() {
		return cargo;
		
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
		
	}
	
	@Override
	public String toString() {
		return "Funcionario [cargo=" + cargo + "]";
		
	}

}