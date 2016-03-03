package plic.arbre.expression;

import plic.exceptions.AnalyseException;
import plic.exceptions.SemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class NonLogique extends Unaire {
    
    public NonLogique(Expression expr, int i) {
        super(expr);
        this.ligne = i;
    }
    
    public void verifier() throws AnalyseException{    	
    	expression.verifier();
    	if (expression.getType().equals("bool")){
    		this.setType("bool");
    	}else{
    		throw new SemantiqueException("Mauvais types, booléen attendu", this.getLigne());
    	}
    }

    @Override
    public String operateur() {
        return "non " ;
    }

	@Override
	public String toMips() {
		String non = "";
		non = this.expression.toMips()+"\n"+
	           "	# "+this.toString()+"\n"+	
	      	   "	li $v0,1\n"                    +
	      	   "	add $sp,$sp,4\n"                   +
	      	   "	lw $t8,($sp)\n"                    +
	      	   "	sub $v0,$v0,$t8\n"                 + 
	           "	sw $v0,($sp)\n"                    +
	           "	add $sp,$sp,-4\n";
	return non;
	}

	@Override
	public int valeur() {
		return 1-expression.valeur();
	}
	
}
