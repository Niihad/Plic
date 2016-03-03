package plic.arbre.expression;

import plic.exceptions.AnalyseException;

public class ConstanteBool extends Constante {
    
    public ConstanteBool(String texte, int nLigne) {
        super(texte, nLigne) ;
        this.type = "bool";
    }

	public String toMips() {
		int tmp = (this.cste.equals("true") ? 1 : 0);
		
		StringBuilder bool = new StringBuilder();
		bool.append("	# Range "+ this.cste+ " ("+tmp+")" +" dans $v0 et l'empile\n"+
						  "	li $v0, " + tmp + "\n" +
						  "	sw $v0,($sp) \n" +
						  "	add $sp ,$sp,-4 \n");
		return bool.toString();	
	}

	public void verifier() throws AnalyseException {
	}

}
