package plic.instructions;

import plic.arbre.BlocDInstructions;
import plic.arbre.expression.Expression;
import plic.arbre.tds.EntreeVar;
import plic.arbre.tds.Symbole;
import plic.arbre.tds.SymboleVar;
import plic.arbre.tds.Tds;
import plic.exceptions.SemantiqueException;

public class DeclarationAffectation extends BlocDInstructions {
	
	private String idf, s, t;
	private Expression e ;
	private Affectation affectation;
	
	public DeclarationAffectation(String idf, String s, String t, Expression e, int idfleft){
		this.idf = idf;
		this.s = s;
		this.t = t;
		this.e = e;
		Symbole sy = new SymboleVar(s,t);
		sy.setValeur(e.valeur());
		Tds.getInstance().ajouterChamp(new EntreeVar(idf, idfleft), sy);
		affectation = new Affectation(idf, e, idfleft);
	}
	
	@Override
	public void verifier() throws SemantiqueException {
		affectation.verifier();
	}

	@Override
	public String toString(){
		return "DeclarationAffectation d'un "+t+" "+s+" appele "+idf+ " avec valeur "+e;		
	}

	@Override
	public String toMips() {
		return affectation.toMips();
	}

}
