package plic.arbre;

import plic.arbre.expression.Expression;
import plic.exceptions.SemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class ArbreAbstrait {
    
	public static int cptEtiquette = 0;
	
    protected ArbreAbstrait() {
    }
    
    
   	public void incCptEtiquette(){
   		Expression.cptEtiquette++;
   	}

	public abstract void verifier() throws SemantiqueException;
	
	public abstract String toString();
	
	public abstract String toMips();
    
}
