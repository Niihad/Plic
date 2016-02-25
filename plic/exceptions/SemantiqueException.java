package plic.exceptions;

public class SemantiqueException extends AnalyseException {

	private static final long serialVersionUID = 1L;

	public SemantiqueException(String m, int l) {
		super("ERREUR SEMANTIQUE : Ligne "+l+" : "+m);
	}
}
