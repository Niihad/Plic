package plic.exceptions;

public class DoubleDeclarationException extends SemantiqueException{
	
	private static final long serialVersionUID = 1L;

	public DoubleDeclarationException(String message, int l) {
		super(message,l);
	}

}
