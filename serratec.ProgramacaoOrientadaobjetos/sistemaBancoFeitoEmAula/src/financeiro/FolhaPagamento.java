package financeiro;

import exception.FinanceiroException;
import pessoal.Funcionario;

public class FolhaPagamento {
	
	public double calculaPagamento(Funcionario funcionario) throws FinanceiroException{
		
		if(funcionario.getSalario() + funcionario.getBonificacao() < 1100)
			throw new FinanceiroException("Salário mais bonificação não podem ser menores do que R$ 1100,00");
		
		double pagamento =  funcionario.getSalario() + funcionario.getBonificacao();
		return pagamento;
	}
}
