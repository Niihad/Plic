package plic.arbre.expression;

import plic.arbre.tds.Entree;
import plic.arbre.tds.Symbole;
import plic.arbre.tds.Tds;
import plic.exceptions.AnalyseException;

public class ConstanteVariable extends Constante {
	
	private Symbole s;

	public ConstanteVariable(String texte, int nLigne) {
		super(texte, nLigne);
		this.verifier();	
	}
	
	@Override
	public void verifier() throws AnalyseException {
		this.s = Tds.getInstance().identifier(new Entree(this.cste));	
		type = s.getType();
	}

	@Override
	public String toMips() {
		StringBuilder entier = new StringBuilder();
		entier.append("	# Range valeur de "+ this.cste +" dans $v0 et l'empile\n"+
			  	  "	lw $v0,"+ s.getDepl() +"($s7)\n" +
			  	  "	sw $v0,($sp) \n" +
			  	  "	add $sp ,$sp,-4 \n");
		return entier.toString();
	}

}
