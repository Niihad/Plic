package plic.instructions;

import plic.arbre.BlocDInstructions;
import plic.arbre.tds.EntreeVar;
import plic.arbre.tds.SymboleVar;
import plic.arbre.tds.Tds;
import plic.exceptions.SemantiqueException;

public class Declaration extends BlocDInstructions {
	
	private String idf, s, t;
	
	public Declaration(String idf, int idfleft, String s, String t){
		this.idf = idf;
		this.s = s;
		this.t = t;
		Tds.getInstance().ajouterChamp(new EntreeVar(idf, idfleft), new SymboleVar(s,t));
	}
	
	@Override
	public void verifier() throws SemantiqueException {
	}

	@Override
	public String toString(){
		return "Declaration d'un "+t+" "+s+" appele "+idf;		
	}

	@Override
	public String toMips() {
		return "";
	}

}
