package plic.instructions;

import plic.arbre.ArbreAbstrait;
import plic.arbre.tds.Entree;
import plic.arbre.tds.Symbole;
import plic.arbre.tds.Tds;
import plic.exceptions.SemantiqueException;

public class Declaration extends ArbreAbstrait {
	
	private String idf, s, t;
	
	public Declaration(String idf, int idfleft, String s, String t){
		this.idf = idf;
		this.s = s;
		this.t = t;
		Tds.getInstance().ajouterChamp(new Entree(idf, idfleft), new Symbole(s,t));
	}
	
	@Override
	public void verifier() throws SemantiqueException {
	}

	@Override
	public String toString(){
		return "Declaration d'un "+t+" "+s+" appelé "+idf;		
	}

	@Override
	public String toMips() {
		return "";
	}

}
