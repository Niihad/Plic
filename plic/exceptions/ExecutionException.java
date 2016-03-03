package plic.exceptions;

public class ExecutionException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExecutionException(String m, int l) {
		super("ERREUR EXECUTION : Ligne "+l+" : "+m);
	}
	
}
