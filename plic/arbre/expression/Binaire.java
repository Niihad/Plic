package plic.arbre.expression;

import plic.exceptions.AnalyseException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Binaire extends Expression {
    
    protected Expression gauche ;
    protected Expression droite ;

    protected Binaire(Expression gauche, Expression droite) {
        super();
        this.gauche = gauche;
        this.droite = droite;
    }
    
    public abstract String operateur() ;

    public void verifier() throws AnalyseException{    	
    	/*gauche.verifier();
    	droite.verifier();
    	if (gauche.getType() != droite.getType() ){
    		throw new SemantiqueException("Mauvais types");
    	}*/
    } 
    
    @Override
    public String toString() {
        return "(" + gauche + operateur() + droite + ")" ;
    }

}
