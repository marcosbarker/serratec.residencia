package conta;

public class ContaCorrente extends Conta {

	private Integer investimento;
	private Integer tarifa;
	
	public ContaCorrente() {
	}
	
	public ContaCorrente(String tipo, Integer agencia, Integer numero, double saldo, Integer idCliente, Integer tarifa, Integer investimento) {
		super(tipo, agencia, numero, saldo, idCliente);
		this.tarifa = tarifa;
		this.investimento = investimento;
	}

	public Integer getInvestimento() {
		return investimento;
	}
	
	public void setInvestimento(Integer investimento) {
		this.investimento = investimento;
	}
	
	public Integer getTarifa() {
		return tarifa;
	}
	
	public void setTarifa(Integer tarifa) {
		this.tarifa = tarifa;
	}

}
