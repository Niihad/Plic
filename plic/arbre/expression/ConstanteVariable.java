package plic.arbre.expression;

import plic.arbre.tds.Entree;
import plic.arbre.tds.Tds;
import plic.exceptions.AnalyseException;
import plic.exceptions.SemantiqueException;

public class ConstanteVariable extends Constante {

	public ConstanteVariable(String texte, int nLigne) throws SemantiqueException {
		super(texte, nLigne);
		if (Tds.getInstance().identifier(new Entree(texte)) != null){
			System.out.println("oui");
	        this.type = Tds.getInstance().identifier(new Entree(texte)).getType();	
		}else{
			throw new SemantiqueException("Mauvais type lors de l'affectation", nLigne);
		}
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
