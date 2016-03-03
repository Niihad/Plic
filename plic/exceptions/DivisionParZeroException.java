package plic.exceptions;


public class DivisionParZeroException extends ExecutionException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DivisionParZeroException(String m, int l) {
        super(m, l);
    }

}
