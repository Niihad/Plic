package plic.exceptions;

public class PasDeDeclarationException extends SemantiqueException{
	
	private static final long serialVersionUID = 1L;

	public PasDeDeclarationException(String message, int l) {
		super(message,l);
	}
	
}
