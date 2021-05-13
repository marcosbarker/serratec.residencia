package exception;

public class FinanceiroException extends Exception {

	private static final long serialVersionUID = 1L;

	public FinanceiroException() {
	        super();
	    }

	public FinanceiroException(String message) {
	        super(message);
	    }

	public FinanceiroException(String message, Throwable cause) {
	        super(message, cause);
	    }

	public FinanceiroException(Throwable cause) {
	        super(cause);
	    }

}
