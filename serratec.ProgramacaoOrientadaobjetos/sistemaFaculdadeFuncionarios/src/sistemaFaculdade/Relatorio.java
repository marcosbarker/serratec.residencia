package sistemaFaculdade;

public class Relatorio {
	private double gastosTotais;

	public double getGastosTotais() {
		return gastosTotais;
	}

	public void relatorio(Empregado empregado) {
		System.out.println(empregado.toString() + "\n----------------------"); 
	}
	public void gastos(Empregado gasto) {
		gastosTotais += gasto.getSalario();
	}
}
