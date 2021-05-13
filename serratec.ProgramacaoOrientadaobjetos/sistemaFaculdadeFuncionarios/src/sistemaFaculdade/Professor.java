package sistemaFaculdade;

public class Professor extends Empregado {
	private int horasDeAula;

	public Professor(String nome, double salario, int horasDeAula) {
		super(nome, salario);
		this.horasDeAula = horasDeAula;
	}

	public double getHorasDeAula() {
		return horasDeAula;
	}
	
	public double getGastos() {
		return salario += (horasDeAula * 10);
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nHoras de Aula: " + horasDeAula;
	}
}
