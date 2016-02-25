package plic.arbre.tds;

import java.util.HashMap;

import plic.exceptions.DoubleDeclarationException;
import plic.exceptions.PasDeDeclarationException;

public class Tds {
	
	HashMap<Entree, Symbole> tds;
	private int nbLigne;

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
			throw new DoubleDeclarationException(entree.getEntree() +" est déja déclaré");
		}else{ // sinon ajoute la variable dans la hashMap
			tds.put(entree, s);
			s.setDeplacement(s.getDeplacement() + 4);;
		}
	}	
	
	public Symbole identifier(Entree entree) throws PasDeDeclarationException{
		Symbole s = tds.get(entree.getEntree());
		if(s==null){
			throw new PasDeDeclarationException(entree.getEntree() +" n'a pas été déclaté !");
		}
		return tds.get(entree.getEntree());
	}

	

}
