package plic.arbre.expression;

import plic.exceptions.AnalyseException;
import plic.exceptions.SemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Comparaison extends Binaire {
     
    protected Comparaison(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
   
    public void verifier() throws AnalyseException{    	
    	gauche.verifier();
    	droite.verifier();
    	if (gauche.getType().equals(droite.getType())){
    		if(gauche.getType() == "bool"){
    			if (this.operateur() == " > " || this.operateur() == " < ")
    				throw new SemantiqueException("La comparaison inf/sup attend un entier", this.getLigne());
    		}
    		this.setType("bool");
    	}else{
        	throw new SemantiqueException("Types incompatibles pour la comparaison", this.getLigne());
    	}
    }

}
