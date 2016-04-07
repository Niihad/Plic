package plic.instructions;

import plic.arbre.BlocDInstructions;
import plic.arbre.expression.Expression;
import plic.arbre.tds.EntreeVar;
import plic.arbre.tds.Symbole;
import plic.arbre.tds.Tds;
import plic.exceptions.MauvaisTypeException;
import plic.exceptions.PasDeDeclarationException;
import plic.exceptions.SemantiqueException;

public class Affectation extends BlocDInstructions{

	private String idf ;
	private Expression expr ;
	private int nbLigne;
	
	public Affectation(String idf, Expression e, int nbLigne){
		super();
		this.idf = idf;
		this.expr = e;
		this.nbLigne = nbLigne;
	}
	
	public void verifier() throws SemantiqueException {
		Tds.getInstance().verifier(new EntreeVar(idf, nbLigne),expr);
		Symbole s = Tds.getInstance().identifier(new EntreeVar(idf, nbLigne),nbLigne);
		expr.verifier();
		if(!s.getType().equals(expr.getType())){
			throw new MauvaisTypeException("Type non conforme, renseigne:"+Tds.getInstance().identifier(new EntreeVar(idf),nbLigne).getType()+", attendu :"+ expr.getType(),expr.getLigne());
		}
	}
	
	@Override
	public String toString(){
		return "Affectation de "+idf+" à la valeur "+expr.toString();		
	}

	
	@Override
	public String toMips() throws PasDeDeclarationException{
		 StringBuilder affectation = new StringBuilder();
		 affectation.append("\n" + expr.toMips() + "\n");
		 affectation.append("	# Affectation de "+idf+" a la valeur de "+expr.toString()+"\n");
		 affectation.append("	add $sp,$sp,4 \n" +
		 					"	lw $v0,($sp) \n" +
		 					"	sw $v0,"+ Tds.getInstance().getDeplacement(new EntreeVar(idf)) +"($s7)\n");
		 return affectation.toString() ;
	}
	
	

}
