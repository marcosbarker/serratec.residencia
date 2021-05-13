package sistemaFaculdade;

public class Empregado {
	protected String nome;
	protected double salario;

	public Empregado(String nome, double salario) {
		this.nome = nome;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public double getSalario() {
		return salario;
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\nSalario: R$ " + salario;
	}

}