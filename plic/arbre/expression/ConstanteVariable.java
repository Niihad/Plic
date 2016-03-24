package plic.arbre.expression;

import plic.arbre.tds.Entree;
import plic.arbre.tds.EntreeVar;
import plic.arbre.tds.Symbole;
import plic.arbre.tds.Tds;
import plic.exceptions.AnalyseException;
import plic.exceptions.SemantiqueException;

public class ConstanteVariable extends Constante {
	
	private Symbole s;
	private int valeur;
	private int ligne;

	public ConstanteVariable(String texte, int nLigne) {
		super(texte, nLigne);
		ligne = nLigne;
	}
	
	public int valeur(){
		this.verifier();
		return valeur;
	}
	
	@Override
	public void verifier() throws AnalyseException {
		this.s = Tds.getInstance().getTds().get(new EntreeVar(this.cste));
		if(s == null){
			Expression exp = Tds.getInstance().getAttente().get(new EntreeVar(this.cste));
			if (exp == null)
				throw new SemantiqueException("Variable utilisee en tant que membre droit avant d'etre declaree", ligne); // num ligne a ajouter
			valeur = exp.valeur();
			type = exp.getType();
		}else{
			valeur = s.getValeur();
			type = s.getType();
		}
	}

	@Override
	public String toMips() {
		StringBuilder entier = new StringBuilder();
		this.s = Tds.getInstance().getTds().get(new EntreeVar(this.cste));
		entier.append("	# Range valeur de "+ this.cste +" dans $v0 et l'empile\n"+
			  	  "	lw $v0,"+ s.getDepl() +"($s7)\n" +
			  	  "	sw $v0,($sp) \n" +
			  	  "	add $sp ,$sp,-4 \n");
		return entier.toString();
	}

}
