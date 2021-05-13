package exception;

public class ContaException extends Exception {

	private static final long serialVersionUID = 1L;

	public ContaException() {
	        super();
	    }

	public ContaException(String message) {
	        super(message);
	    }

	public ContaException(String message, Throwable cause) {
	        super(message, cause);
	    }

	public ContaException(Throwable cause) {
	        super(cause);
	    }

}
