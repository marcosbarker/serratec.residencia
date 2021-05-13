package pessoal;

public class OperadorCaixa extends Funcionario {
	private int terminalCaixa;

	public int getTerminalCaixa() {
		return terminalCaixa;
	
	}

	public void setTerminalCaixa(int terminalCaixa) {
		this.terminalCaixa = terminalCaixa;
	
	}

	@Override
	public String toString() {
		return "OperadorCaixa [\n\tterminalCaixa=" + terminalCaixa + ", \n\tgetNome()=" + getNome()
				+ ", \n\tgetSalario()=" + getSalario() + ", \n\tgetCpf()=" + getCpf() + "\n]";
	
	}

	@Override
	public double getBonificacao() {
		return this.salario * 0.5;
	
	}

}