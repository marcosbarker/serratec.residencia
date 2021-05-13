package conta;

import sistemExceptions.DepositoIndevido;

public class ContaCorrente extends Conta implements Comparable<Conta> {

	protected int tipo;
	protected double taxas;

	public ContaCorrente() {

	}

	public ContaCorrente(String titular, int cpf, int numero, int agencia, double saldo, int tipo) {
		this.titular = titular;
		this.cpf = cpf;
		this.numero = numero;
		this.agencia = agencia;
		this.saldo = saldo;
		this.tipo = tipo;

	}

	public void atualiza(double taxaSelic) {
		super.atualiza(taxaSelic * 2);

	}

	public double calculaTributos() {
		return this.saldo * 0.01;

	}

	@Override
	public int compareTo(Conta outraConta) {
		if (this.numero > outraConta.numero) {
			return -1;

		} else if (this.numero < outraConta.numero) {
			return 1;

		} else {
			return 0;

		}
	}

	@Override
	public boolean saque(double valor) {
		if (this.saldo < (valor + 0.10)) {
			System.out.println("Saldo insuficiente!!!");
			return false;

		} else {
			this.saldo = this.saldo - (valor + 0.10);
			this.taxas = this.taxas + 0.10;
			return true;

		}
	}

	@Override
	public void deposito(double valor) {
		if (valor > 0.1) {
			this.saldo += (valor - 0.10);
			this.taxas = this.taxas + 0.10;

		} else {
			throw new DepositoIndevido("Valor de deposito invalido");

		}
	}

	@Override
	public boolean transfere(Conta destino, double valor) {
		if (this.saldo >= (valor + 0.20)) {
			destino.saldo = destino.saldo + valor;
			this.saldo = this.saldo - (valor + 0.20);
			this.taxas = this.taxas + 0.20;

			return true;

		} else {
			System.out.println("Não há saldo suficiente para transferir esse valor!!!");
			return false;

		}
	}

	public double consultaTotalTaxas() {
		return this.taxas;

	}

	public int getTipo() {
		return tipo;

	}

	@Override
	public void consultaTipo() {

	}

	@Override
	public double seguroDeVida(double valor) {
		if (this.saldo >= valor * 0.2) {
			double valorApolice = valor * 0.2;
			this.saldo = this.saldo - valorApolice;
			return valorApolice;

		} else {
			return 0;

		}
	}
}