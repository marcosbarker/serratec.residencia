package sistemExceptions;

public class DepositoIndevido extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public DepositoIndevido (String mensagem) {
			super (mensagem);
			
	}
}