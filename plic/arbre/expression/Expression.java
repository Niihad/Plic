package plic.arbre.expression;

import plic.arbre.ArbreAbstrait;
import plic.exceptions.AnalyseException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Expression extends ArbreAbstrait {
    
	protected String type;
	protected int ligne;
	
    protected Expression() {
        super() ;
    }
    
    public abstract int valeur();
	
	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type = type;
	}

	public abstract void verifier() throws AnalyseException;
	
	public int getLigne() {
		return ligne;
	}

	public void setLigne(int l){
		this.ligne = l;
	}
}
