package pessoal;

public class Gerente extends Funcionario{

	private int numFuncionarios;
	
	public Gerente() {
		super();
	}

	public Gerente(String tipo, String nome, Integer id, String cpf, String senha, Integer agencia, double salario, Integer numeroConta, Integer numFuncionarios) {
		super(tipo, nome, id, cpf, senha, agencia, salario, numeroConta);
		this.numFuncionarios = numFuncionarios;
	}

	public int getNumFuncionarios() {
		return numFuncionarios;
	}

	public void setNumFuncionarios(int numFuncionarios){
		this.numFuncionarios = numFuncionarios;
	}
	
	@Override
	public double getBonificacao() {
		return this.getSalario()*0.15; 
	}

}
