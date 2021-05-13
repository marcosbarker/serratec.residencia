package conta;

public class ContaPoupanca extends Conta{
	
	private Integer vencimento;
	private double rendimento;

	public ContaPoupanca() {
	}
	
	public ContaPoupanca(String tipo, Integer agencia, Integer numero, double saldo, Integer idCliente, Integer vencimento, double rendimento) {
		super(tipo, agencia, numero, saldo, idCliente);
		this.vencimento = vencimento;
		this.rendimento = rendimento;
	}

	public Integer getVencimento() {
		return vencimento;
	}
	public void setVencimento(Integer vencimento) {
		this.vencimento = vencimento;
	}
	public double getRendimento() {
		return rendimento;
	}
	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}

}
