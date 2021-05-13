package funcionario;

public class Gerente extends Funcionario{
	protected int agencia;

	public Gerente(String nome, int senha, int cpf, String cargo) {
		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;
		this.cargo = cargo;
		
	}
}