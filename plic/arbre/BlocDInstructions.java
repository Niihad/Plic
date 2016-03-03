package plic.arbre;

import java.util.ArrayList;

import plic.arbre.tds.Tds;
import plic.exceptions.SemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends ArbreAbstrait {
    
    protected ArrayList<ArbreAbstrait> instr ;
    
    public BlocDInstructions() {
        super() ;
        instr = new ArrayList<ArbreAbstrait>();
    }
    
    public void ajouter(ArbreAbstrait a) {
        instr.add(a) ;
    }
    
    @Override
    public String toString() {
    	String str = "";
    	for (ArbreAbstrait a : instr){
    		str+=a.toString();
    		str+="\n";
    	}
    	return str;
    }

	@Override
	public void verifier() throws SemantiqueException {
		for (ArbreAbstrait a : instr){
    		a.verifier();
    	}
	}

	@Override
	public String toMips() {
		StringBuilder sb = new StringBuilder();
		sb.append("# zone de reservation de memoire\n\n");
		sb.append("	# initialise s7 avec sp \n"); 
		sb.append("	move $s7,$sp \n");
		for(int i=0;i<Tds.getInstance().getTds().size();i++){
			sb.append("	addi $sp ,$sp,-4 \n");
		}
		sb.append("\n# zone programme\n");
		for (ArbreAbstrait a : instr){
    		sb.append(a.toMips());
    	}
		sb.append("\nend :\n");
		sb.append("	move $v1, $v0	# copie de v0 dans v1 pour permettre les tests de plic0\n");
		sb.append("	li $v0, 10	# retour au système\n");
		sb.append("	syscall\n");
		return sb.toString();		
	}

}
