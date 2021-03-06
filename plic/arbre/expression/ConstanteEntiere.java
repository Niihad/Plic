package plic.arbre.expression;

import plic.exceptions.AnalyseException;

public class ConstanteEntiere extends Constante {
    
	private int nbr;
	
    public ConstanteEntiere(String texte, int nLigne) {
        super(texte, nLigne) ;
        this.nbr = Integer.parseInt(texte);
        this.type = "entier";
    }
    
    public int valeur(){
    	return nbr;
    }

	@Override
	public String toMips() {
		StringBuilder entier = new StringBuilder();
		entier.append("	# Range "+ this.cste +" dans $v0 et l'empile\n"+
						  "	li $v0, " + this.cste + "\n" +
						  "	sw $v0,($sp) \n" +
						  "	add $sp ,$sp,-4 \n");
		return entier.toString();
	}

	public void verifier() throws AnalyseException {
	}

}
