package plic.arbre.expression;

import plic.exceptions.AnalyseException;
import plic.exceptions.SemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireLogique extends Binaire {

    protected BinaireLogique(Expression gauche, Expression droite) {
        super(gauche, droite) ;
    }
    
public void verifier() throws AnalyseException{
    	
    	gauche.verifier();
    	droite.verifier();
    	if (gauche.getType().equals(droite.getType()) && gauche.getType().equals("bool")){
    		this.setType("bool");
    	}
    	else{
    		throw new SemantiqueException("Mauvais types, booleen attendu", this.getLigne());
    	}
    }
    
}
