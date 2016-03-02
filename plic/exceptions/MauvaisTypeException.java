package plic.exceptions;

public class MauvaisTypeException extends SemantiqueException{
	
	private static final long serialVersionUID = 1L;

	public MauvaisTypeException(String message, int l) {
		super(message,l);
	}
	
}
