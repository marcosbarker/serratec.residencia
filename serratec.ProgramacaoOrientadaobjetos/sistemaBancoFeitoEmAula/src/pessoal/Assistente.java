package pessoal;

public class Assistente extends Funcionario{
	private String funcionarioAssistido;
	
	

	public Assistente() {
		super();
	}

	public Assistente(String tipo, String nome, Integer id, String cpf, String senha, Integer agencia, double salario, Integer numeroConta, String funcionarioAssistido) {
		super(tipo, nome, id, cpf, senha, agencia, salario, numeroConta);
		this.funcionarioAssistido = funcionarioAssistido;
	}

	public String getFuncionarioAssistido() {
		return funcionarioAssistido;
	}

	public void setFuncionarioAssistido(String funcionarioAssistido) {
		this.funcionarioAssistido = funcionarioAssistido;
	}

	@Override
	public double getBonificacao() {
		return this.getSalario()*0.10;
	}

}
