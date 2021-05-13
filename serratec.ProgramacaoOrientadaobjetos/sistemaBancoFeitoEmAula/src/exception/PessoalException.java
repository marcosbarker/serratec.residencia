package exception;

public class PessoalException extends Exception {

	private static final long serialVersionUID = 1L;

	public PessoalException() {
	        super();
	    }

	public PessoalException(String message) {
	        super(message);
	    }

	public PessoalException(String message, Throwable cause) {
	        super(message, cause);
	    }

	public PessoalException(Throwable cause) {
	        super(cause);
	    }

}
