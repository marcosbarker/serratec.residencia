package conta;

import exception.ContaException;

public abstract class Conta {
	private static int totalDeContas;

	private String tipo;
	private Integer agencia;
	private Integer numero;
	private double saldo;
	private Integer idCliente;
	
	public Conta() {
		totalDeContas++;
	}
	
	public Conta(String tipo, Integer agencia, Integer numero, double saldo, Integer idCliente) {
		super();
		this.agencia = agencia;
		this.numero = numero;
		this.tipo = tipo;
		this.saldo = saldo;
		this.idCliente = idCliente;
		totalDeContas++;
	}
	
	public Integer getTotalContas() {
		return totalDeContas;
	}
	
	public Integer incrementaTotalContas() {
		return totalDeContas++;
	}
	
	public boolean sacar(double valor) {
		if(this.saldo < valor) {
			return false;
		}
		else {
			this.saldo = this.saldo - valor;
			return true;
		}
	}
	
	public boolean transfere(Conta destino, double valor) {
		
		boolean retirou = this.sacar(valor);
		if (retirou) {
			// não deu pra sacar!
			destino.depositar(valor);
			return true;
		} 
		else {
			return false;
		}
	}
	
	public double depositar(double valor) {
		this.saldo = this.saldo + valor;
		return this.saldo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) throws ContaException{
		if(numero <= 0)
			throw new ContaException("Número da conta não pode ser menor ou igual a zero!");
		this.numero = numero;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public String toString() {
		return "Conta\n\ttipo=" + tipo + ", \n\tagencia=" + agencia + ", \n\tnumero=" + numero + ", \n\tsaldo=" + saldo
				+ ", \n\tidCliente=" + idCliente;
	}

	
}
