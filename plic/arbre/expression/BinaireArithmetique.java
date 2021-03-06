package plic.arbre.expression;

import plic.exceptions.AnalyseException;
import plic.exceptions.SemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireArithmetique extends Binaire {

    protected BinaireArithmetique(Expression gauche, Expression droite) {
        super(gauche, droite) ;
    }
    
    public void verifier() throws AnalyseException{
    	gauche.verifier();
    	droite.verifier();
    	if (gauche.getType().equals(droite.getType()) && gauche.getType().equals("entier")){
    		this.setType("entier");
    	}else{
    		throw new SemantiqueException("Mauvais types "+droite.getType()+", entier attendu "+gauche.getType(), this.getLigne());
    	}
    }    
}
