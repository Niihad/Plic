package plic.arbre.expression;

import plic.exceptions.AnalyseException;
import plic.exceptions.SemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class MoinsUnaire extends Unaire {
    
    public MoinsUnaire(Expression expr, int i) {
        super(expr);
        this.ligne = i;
    }

    public void verifier() throws AnalyseException{    	
    	expression.verifier();
    	if (expression.getType().equals("entier")){
    		this.setType("entier");
    	}else{
    		throw new SemantiqueException("Mauvais types, entier attendu",ligne);
    	}
    }
    
    public int valeur(){
    	return -expression.valeur();
    }
    
    @Override
    public String operateur() {
        return "- " ;
    }

	@Override
	public String toMips() {
		String moins = "";
		moins = this.expression.toMips()+"\n" +
	        "	# inverse le signe de "+this.expression+"\n"+
	        "	add $sp,$sp,4\n"                  +	
	   	   	"	lw $v0,($sp)\n"                   +
	   	   	"	li $t8, 0\n"                   +
	   	   	"	sub $v0,$t8,$v0\n"                +
	        "	sw $v0,($sp)\n"                   +
	        "	add $sp,$sp,-4\n";
			return moins;
		}

}
