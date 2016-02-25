package plic.exceptions;

/**
 * 10 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class AnalyseSyntaxiqueException extends AnalyseException {
 
	private static final long serialVersionUID = 1L;

	public AnalyseSyntaxiqueException(String m) {
        super("ERREUR SYNTAXIQUE :\n\t" + m) ;
    }

}
