package pessoal;

public class Estagiario extends Assistente {
	
	
	public Estagiario() {
		super();
	}

	public Estagiario(String tipo, String nome, Integer id, String cpf, String senha, Integer agencia, double salario,
			String funcionarioAssistido, Integer numeroConta) {
		super(tipo, nome, id, cpf, senha, agencia, salario, numeroConta, funcionarioAssistido);
	}

	@Override
	public double getBonificacao() {
		return this.getSalario()*0.10; 
	}
	
}
