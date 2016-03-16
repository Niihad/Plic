package plic.instructions;

import plic.arbre.ArbreAbstrait;
import plic.exceptions.SemantiqueException;

public class EcrireChaine extends ArbreAbstrait {

	private String chaine;
	
	public EcrireChaine(String chaine){
		super();
		this.chaine = convertirCote(chaine);
	}

	// Permet de retirer les quotes
	private String convertirCote(String chaine2) {
		chaine2 = chaine2.substring(1, chaine2.length()-1);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < chaine2.length(); i++){
			char c = chaine2.charAt(i);
			if(c != '"'){
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	@Override
	public void verifier() throws SemantiqueException {
	}

	@Override
	public String toMips() {
		StringBuilder ecrire = new StringBuilder(); 
		ecrire.append("	\n# Ecrirechaine\n");
		ecrire.append("	.data \n");
		ecrire.append("	stri"+ArbreAbstrait.cptEtiquette+": .asciiz \"" + chaine +"\"\n");
		ecrire.append("	.text \n");
		ecrire.append("	li $v0, 4 \n");
		ecrire.append("	la $a0, stri"+ ArbreAbstrait.cptEtiquette +"\n");
		ecrire.append("	syscall\n") ;
		incCptEtiquette();
		return ecrire.toString() ;
	}

	@Override
	public String toString() {
		return "Ecriture de la chaine: "+chaine;
	}

}
