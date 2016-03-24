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
	private int etiquette;

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
					+ (alors != null ? alors.toString() : "") + "\n\tSinon: \n" + sinon.toString()
					+ "\nFinSi";
		else
			return "Conditionnelle si " + expr.toString() + "\n\tAlors: \n"
					+ (alors != null ? alors.toString() : "") + "\nFinSi";

	}

	@Override
	public String toMips() {
		this.etiquette = ArbreAbstrait.cptEtiquette;
        StringBuilder condition = new StringBuilder();
        condition.append("\n" + expr.toMips() + "\n");
        condition.append("    # Conditionnelle de " + expr.toString() + "\n");
        condition.append("    add $sp,$sp,4 \n" 
				+ "	lw $v0,($sp) \n"
        		+ "    si"
                + etiquette + (sinon != null ? ": blez $v0, sinon" : ": blez $v0, finsi")
                + etiquette + "\n" + "    alors"
                + etiquette+ ":\n" + "        "
                + (alors != null ?  alors.toMips() : "") + "    j finsi" + etiquette);
        if(sinon != null){
            condition.append("\n" + "    sinon" + etiquette + ":\n"+ "        " + sinon.toMips());
        }
        condition.append("\nfinsi" + etiquette + ":\n");
        incCptEtiquette();
        return condition.toString();
	}

}
