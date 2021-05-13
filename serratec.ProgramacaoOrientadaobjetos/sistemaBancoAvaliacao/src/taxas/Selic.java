package taxas;

import conta.Conta;

public class Selic {
	private double saldoTotal = 0;
	private double selic;
	double taxa;

	public Selic(double selic) {
		this.selic = selic;

	}

	public void roda(Conta c) {
		System.out.println("Saldo Inicial da Conta: " + c.getSaldo());
		c.atualiza(this.selic);
		System.out.println("Valor atualizado: " + c.getSaldo());
		saldoTotal += c.getSaldo();

	}

	public double getSaldoTotal() {
		return saldoTotal;

	}
}