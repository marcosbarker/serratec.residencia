package pessoal;

import exception.PessoalException;

public abstract class Funcionario extends Usuario{
	
	private double salario;

	
	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Funcionario(String tipo, String nome, Integer id, String cpf, String senha, Integer agencia, double salario, Integer numeroConta) {
		super(tipo, nome, id, cpf, senha, agencia, numeroConta);
		this.salario = salario;
	}

	public double getBonificacao() {
		return this.salario * 0.10;
	}
	
	public double getSalario() {
		return this.salario;
	}
	
	public void setSalario(double salario) throws PessoalException {
		if(salario <= 0)
			throw new PessoalException("Salário base do funcionário não pode ser menor ou igual a zero");
		this.salario = salario;
	}
}
