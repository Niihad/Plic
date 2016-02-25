package plic.arbre;

import plic.exceptions.SemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class ArbreAbstrait {
    
    protected ArbreAbstrait() {
    }

	public abstract void verifier() throws SemantiqueException;
	
	public abstract String toMips();
    
}
