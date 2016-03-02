package plic.arbre.tds;

import java.util.HashMap;

import plic.exceptions.DoubleDeclarationException;
import plic.exceptions.PasDeDeclarationException;

public class Tds {
	
	private HashMap<Entree, Symbole> tds;
	private int deplacement;
	private String dernierStatut = null;
	private String dernierType = null;
	
	private Tds(){
		tds =  new HashMap<Entree, Symbole>();
	}
	
	private static Tds instance = new Tds();
	
	public static Tds getInstance(){
		return instance ;
	}
	
	public HashMap<Entree, Symbole> getTds() {
		return tds;
	}

	public void setTds(HashMap<Entree, Symbole> tds) {
		this.tds = tds;
	}

	public void ajouterChamp(Entree entree, Symbole s) throws DoubleDeclarationException{
		// si la variable est deja declarée lance une exception 
		if (tds.containsKey(entree.getEntree())){
			throw new DoubleDeclarationException(entree.getEntree() +" est déja déclaré", entree.getLigne());
		}else{ // sinon ajoute la variable da ns la hashMap
			tds.put(entree, s);
			dernierStatut = s.getStatut();
			dernierType = s.getType();
			s.setDepl(deplacement);
			switch (s.getType()){
			case "entier":
				deplacement -= 4;
				break;
			case "reel":
				deplacement -= 8;
				break;
			}			
		}
	}	
	
	public Symbole identifier(Entree entree) throws PasDeDeclarationException{
		Symbole s = tds.get(entree.getEntree());
		if(s==null){
			throw new PasDeDeclarationException(entree.getEntree() +" n'a pas été déclaré !", entree.getLigne());
		}
		return tds.get(entree.getEntree());
	}

	public String getDernierStatut() {
		return dernierStatut;
	}

	public String getDernierType() {
		return dernierType;
	}
}
