package plic.arbre;

import java.util.ArrayList;

import plic.exceptions.SemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends ArbreAbstrait {
    
    protected ArbreAbstrait expr ;
    
    public BlocDInstructions() {
        super() ;
    }
    
    public void ajouter(ArbreAbstrait a) {
        expr = a ;
    }
    
    @Override
    public String toString() {
        return expr.toString();
    }

	@Override
	public void verifier() throws SemantiqueException {
		expr.verifier();
	}

	@Override
	public String toMips() {
		StringBuilder sb = new StringBuilder();
		sb.append("# zone de reservation de memoire\n\n");
		sb.append("	# initialise s7 avec sp \n"); 
		sb.append("	la $s7,($sp) \n");
		sb.append("\n# zone programme\n\n");
		sb.append(expr.toMips() +"\n");
		sb.append("end :\n");
		sb.append("	move $v1, $v0	# copie de v0 dans v1 pour permettre les tests de plic0\n");
		sb.append("	li $v0, 10	# retour au système\n");
		sb.append("	syscall\n");
		return sb.toString();		
	}

}
