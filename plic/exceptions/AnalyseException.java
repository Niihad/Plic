package plic.exceptions;

/**
 * 10 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class AnalyseException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;
	
    protected AnalyseException(String m) {
        super(m) ;
    }
    
}
