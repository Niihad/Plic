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

	protected ArrayList<ArbreAbstrait> instr;

	public BlocDInstructions() {
		super();
		instr = new ArrayList<ArbreAbstrait>();
	}

	public void ajouter(ArbreAbstrait a) {
		// if (a != null)
		instr.add(a);
	}

	@Override
	public String toString() {
		String str = "";
		for (ArbreAbstrait a : instr) {
			if (a != null) {
				str += a.toString();
				str += "\n";
			}
		}
		return str;
	}

	@Override
	public void verifier() throws SemantiqueException {
		for (ArbreAbstrait a : instr) {
			if (a != null)
				a.verifier();
		}
	}

	@Override
	public String toMips() {
		StringBuilder sb = new StringBuilder();
		sb.append("# zone de reservation de memoire\n\n");
		sb.append("	# initialise s7 avec sp \n");
		sb.append("	move $s7,$sp \n");
		sb.append("	# reserve les zones memoire des variables \n");
		for (int i = 0; i < Tds.getInstance().getTds().size(); i++) {
			sb.append("	addi $sp ,$sp,-4 \n");
		}
		sb.append("\n# zone programme\n");
		for (ArbreAbstrait a : instr) {
			if (a != null)
				sb.append(a.toMips());
		}
		return sb.toString();
	}

}
