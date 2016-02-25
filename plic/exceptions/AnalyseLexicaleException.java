package plic.exceptions;

/**
 * 10 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class AnalyseLexicaleException extends AnalyseException {
 
	private static final long serialVersionUID = 1L;

	public AnalyseLexicaleException(int ligne, int colonne, String m) {
        super("ERREUR LEXICALE :\n\tligne " + ligne + " colonne " + colonne + "\n\t" + m + " : caractère non reconnu") ;
    }

}
