package plic.arbre.expression;

import plic.exceptions.AnalyseException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Unaire extends Expression {
    
    protected Expression expression ;

    protected Unaire(Expression expr) {
        super();
        expression = expr ;
    }
    
    public abstract String operateur() ;

    public void verifier() throws AnalyseException{    	
    	expression.verifier();
    	/*if (expression.getType() == "bool" || expression.getType() == "int"){
    		this.setType(expression.getType() == "bool" ? "bool" : "int");
    	}else{
    		throw new SemantiqueException("Mauvais types, "+expression.getType() == "bool" ? "booleen" : "entier" + " attendu");
    	}*/
    }
    
    @Override
    public String toString() {
        return "(" + operateur() + expression + ")" ;
    }
    
    

}
