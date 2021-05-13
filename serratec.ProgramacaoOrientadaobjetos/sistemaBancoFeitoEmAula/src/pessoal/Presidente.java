package pessoal;

public class Presidente extends Funcionario{

	private double participacaoLucros;
	
	public Presidente() {
		super();
	}

	public Presidente(String tipo, String nome, Integer id, String cpf, String senha, Integer agencia, double salario, Integer numeroConta, double participacaoLucros) {
		super(tipo, nome, id, cpf, senha, agencia, salario, numeroConta);
		this.participacaoLucros = participacaoLucros;
	}

	public double getParticipacaoLucros() {
		return participacaoLucros;
	}

	public void setParticipacaoLucros(double participacaoLucros) {
		this.participacaoLucros = participacaoLucros;
	}

	@Override
	public double getBonificacao() {
		return this.getSalario()*0.20 + 1000; 
	}
	
}