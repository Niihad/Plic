package plic.instructions;

import plic.arbre.ArbreAbstrait;
import plic.arbre.expression.Expression;
import plic.arbre.tds.Entree;
import plic.arbre.tds.Symbole;
import plic.arbre.tds.Tds;
import plic.exceptions.MauvaisTypeException;
import plic.exceptions.PasDeDeclarationException;
import plic.exceptions.SemantiqueException;

public class Affectation extends ArbreAbstrait{

	private String idf ;
	private Expression expr ;
	private int nbLigne;
	
	public Affectation(String idf, Expression e, int nbLigne){
		super();
		this.idf = idf;
		this.expr = e;
		this.nbLigne = nbLigne;
		Tds.getInstance().verifier(new Entree(idf, nbLigne),expr);
	}
	
	public void verifier() throws SemantiqueException {
		Symbole s = Tds.getInstance().identifier(new Entree(idf, nbLigne),nbLigne);
		expr.verifier();
		if(!s.getType().equals(expr.getType())){
			throw new MauvaisTypeException("Type non conforme, renseigne:"+Tds.getInstance().identifier(new Entree(idf),nbLigne).getType()+", attendu :"+ expr.getType(),expr.getLigne());
		}
	}
	
	@Override
	public String toString(){
		return "Affectation de "+idf+" a  la valeur "+expr.toString();		
	}

	
	@Override
	public String toMips() throws PasDeDeclarationException{
		 StringBuilder affectation = new StringBuilder();
		 affectation.append("\n" + expr.toMips() + "\n");
		 affectation.append("	add $sp,$sp,4 \n" +
		 					"	lw $v0,($sp) \n" +
		 					"	sw $v0,"+ Tds.getInstance().getDeplacement(new Entree(idf)) +"($s7)\n");
		 return affectation.toString() ;
	}
	
	

}
