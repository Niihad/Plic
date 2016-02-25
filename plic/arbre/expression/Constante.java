package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Constante extends Expression {

    protected String cste ;
    protected int nLigne;
    
    protected Constante(String texte, int nLigne) {
    	cste = texte ;
        this.nLigne = nLigne;
    }
    
    @Override
    public String toString() {
        return cste ;
    }

}
