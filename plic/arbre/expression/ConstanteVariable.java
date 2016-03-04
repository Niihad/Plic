package plic.arbre.expression;

import plic.arbre.tds.Entree;
import plic.arbre.tds.Symbole;
import plic.arbre.tds.Tds;
import plic.exceptions.AnalyseException;

public class ConstanteVariable extends Constante {
	
	private Symbole s;
	private int valeur;

	public ConstanteVariable(String texte, int nLigne) {
		super(texte, nLigne);
	}
	
	public int valeur(){
		this.verifier();
		return valeur;
	}
	
	@Override
	public void verifier() throws AnalyseException {
		this.s = Tds.getInstance().getTds().get(new Entree(this.cste));
		if(s == null){
			Expression exp = Tds.getInstance().getAttente().get(new Entree(this.cste));
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
		this.s = Tds.getInstance().getTds().get(new Entree(this.cste));
		entier.append("	# Range valeur de "+ this.cste +" dans $v0 et l'empile\n"+
			  	  "	lw $v0,"+ s.getDepl() +"($s7)\n" +
			  	  "	sw $v0,($sp) \n" +
			  	  "	add $sp ,$sp,-4 \n");
		return entier.toString();
	}

}
