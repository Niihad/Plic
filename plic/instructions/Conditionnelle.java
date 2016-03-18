package plic.instructions;

import plic.arbre.ArbreAbstrait;
import plic.arbre.BlocDInstructions;
import plic.arbre.expression.Expression;
import plic.exceptions.MauvaisTypeException;
import plic.exceptions.SemantiqueException;

public class Conditionnelle extends BlocDInstructions {

	private Expression expr;
	private ArbreAbstrait alors;
	private ArbreAbstrait sinon;

	public Conditionnelle(Expression e, ArbreAbstrait alors, ArbreAbstrait sinon) {
		super();
		this.expr = e;
		this.alors = alors;
		this.sinon = sinon;
	}

	public Conditionnelle(Expression e, ArbreAbstrait alors) {
		super();
		this.expr = e;
		this.alors = alors;
		this.sinon = null;
	}

	@Override
	public void verifier() throws SemantiqueException {
		expr.verifier();
		if (!expr.getType().equals("bool")) {
			throw new MauvaisTypeException("Type non conforme, renseigne:"
					+ expr.getType() + ", type boolean attendu",
					expr.getLigne());
		}
		if (sinon != null) {
			if (expr.valeur() == 1) { // Test de la condition
				alors.verifier();
			} else {
				sinon.verifier();
			}
		}
		else{
			if (expr.valeur() == 1){
				alors.verifier();
			}
		}
	}

	@Override
	public String toString() {
		if (sinon != null)
			return "Conditionnelle si " + expr.toString() + "\n\tAlors: \n"
					+ alors.toString() + "\n\tSinon: \n" + sinon.toString()
					+ "\nFinSi";
		else
			return "Conditionnelle si " + expr.toString() + "\n\tAlors: \n"
					+ alors.toString() + "\nFinSi";

	}

	@Override
	public String toMips() {
		StringBuilder condition = new StringBuilder();
		if (sinon != null) {
			condition.append("\n" + expr.toMips() + "\n");
			condition.append("	# Conditionnelle de " + expr.toString() + "\n");
			condition.append("	add $sp,$sp,4 \n" + "	si"
					+ "lw $v0,($sp)"
					+ ArbreAbstrait.cptEtiquette + ": blez $sp, sinon"
					+ ArbreAbstrait.cptEtiquette + "\n" + "	alors"
					+ ArbreAbstrait.cptEtiquette + ":\n" + "		"
					+ alors.toMips() + "	j finsi" + ArbreAbstrait.cptEtiquette
					+ "\n" + "	sinon" + ArbreAbstrait.cptEtiquette + ":\n"
					+ "		" + sinon.toMips() + "\n" + "	finsi"
					+ ArbreAbstrait.cptEtiquette + ":\n");

			incCptEtiquette();
		} else {
			condition.append("\n" + expr.toMips() + "\n");
			condition.append("	# Conditionnelle de " + expr.toString() + "\n");
			condition.append("	add $sp,$sp,4 \n" + "	si"
					+ ArbreAbstrait.cptEtiquette + ": blez $sp, finsi"
					+ ArbreAbstrait.cptEtiquette + "\n" + "	alors"
					+ ArbreAbstrait.cptEtiquette + ":\n" + "		"
					+ alors.toMips() + "	j finsi" + ArbreAbstrait.cptEtiquette
					+ "\n\n	finsi" + ArbreAbstrait.cptEtiquette + ":\n");

			incCptEtiquette();
		}
		return condition.toString();
	}

}
