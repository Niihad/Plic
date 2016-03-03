package plic.instructions;

import plic.arbre.ArbreAbstrait;
import plic.exceptions.SemantiqueException;

public class EcrireExpression extends ArbreAbstrait {

	private String chaine;
	
	public EcrireExpression(String chaine){
		super();
		this.chaine = convertirCote(chaine);
	}

	// Permet de retirer les quotes
	private String convertirCote(String chaine2) {
		chaine2 = chaine2.substring(1, chaine2.length()-1);
		StringBuilder sb = new StringBuilder();
		boolean first = false;
		for(int i = 0; i < chaine2.length(); i++){
			char c = chaine2.charAt(i);
			if(c == '"'){
				first = !first;
				if(!first)
					sb.append('"');
			}else{
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
		ecrire.append("	stri"+this.cptEtiquette+": .asciiz \"" + chaine +"\"\n");
		ecrire.append("	.text \n");
		ecrire.append("	li $v0, 4 \n");
		ecrire.append("	la $a0, stri"+ this.cptEtiquette +"\n");
		ecrire.append("	syscall\n") ;
		incCptEtiquette();
		return ecrire.toString() ;
	}

	@Override
	public String toString() {
		return "Ecriture de la chaine "+chaine;
	}

}
