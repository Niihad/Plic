package plic.instructions;

import plic.arbre.ArbreAbstrait;
import plic.exceptions.SemantiqueException;

public class EcrireChaine extends ArbreAbstrait {

	private String chaine;
	
	public EcrireChaine(String chaine){
		super();
		this.chaine = chaine;
	}
	
	
	@Override
	public void verifier() throws SemantiqueException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toMips() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "Ecriture de la chaine "+chaine;
	}

}
