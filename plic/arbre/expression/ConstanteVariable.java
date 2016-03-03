package plic.arbre.expression;

import plic.arbre.tds.Entree;
import plic.arbre.tds.Tds;
import plic.exceptions.AnalyseException;

public class ConstanteVariable extends Constante {

	protected ConstanteVariable(String texte, int nLigne) {
		super(texte, nLigne);
		if (Tds.getInstance().identifier)
        this.type = Tds.getInstance().identifier(new Entree(texte)).getType();		
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

	@Override
	public void verifier() throws AnalyseException {
		// TODO Auto-generated method stub
		
	}

}
