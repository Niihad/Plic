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
	private Expression e ;
	
	public Affectation(String idf, Expression e){
		super();
		this.idf = idf;
		this.e = e;
	}
	
	public void verifier() throws SemantiqueException {
		Symbole s = Tds.getInstance().identifier(new Entree(idf));
		e.verifier();
		if(!s.getType().equals(e.getType())){
			throw new MauvaisTypeException("Type non conforme, renseigné:"+Tds.getInstance().identifier(new Entree(idf)).getType()+" attendu :"+ e.getType(),e.getLigne());
		}
	}
	
	@Override
	public String toString(){
		return "Affectation de "+idf+" à la valeur "+e.toString();		
	}

	
	@Override
	public String toMips() throws PasDeDeclarationException{
		 StringBuilder affectation = new StringBuilder();
		 affectation.append("\n" + e.toMips() + "\n");
		 affectation.append("	add $sp,$sp,4 \n" +
		 					"	lw $v0,($sp) \n" +
		 					"	sw $v0,"+ Tds.getInstance().getDeplacement(new Entree(idf)) +"($t7)\n");
		 return affectation.toString() ;
	}
	
	

}
