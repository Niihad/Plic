package plic.arbre.tds;

import java.util.HashMap;

import plic.arbre.expression.Expression;
import plic.exceptions.DoubleDeclarationException;
import plic.exceptions.PasDeDeclarationException;

public class Tds {
	
	private HashMap<Entree, Symbole> tds;
	private HashMap<Entree, Expression> attente;
	private int deplacement;
	
	private Tds(){
		tds =  new HashMap<Entree, Symbole>();
		attente =  new HashMap<Entree, Expression>();
	}
	
	private static Tds instance = new Tds();
	
	public static Tds getInstance(){
		return instance ;
	}
	
	public HashMap<Entree, Symbole> getTds() {
		return tds;
	}

	public HashMap<Entree, Expression> getAttente() {
		return attente;
	}


	public void ajouterChamp(Entree entree, Symbole s) throws DoubleDeclarationException{
		// si la variable est deja declarée lance une exception 
		if (tds.containsKey(entree)){
			throw new DoubleDeclarationException(entree.getEntree() +" est deja declare", entree.getLigne());
		}else{ // sinon ajoute la variable da ns la hashMap
			s.setDepl(deplacement);
			Expression exp = attente.get(entree);
			if(exp != null){
				s.setValeur(exp.valeur());
				tds.put(entree, s);
				attente.remove(entree.getEntree());
			}else{
				tds.put(entree, s);
			}
			switch (s.getType()){
			case "entier":
				deplacement -= 4;
				break;
			case "reel":
				deplacement -= 8;
				break;
			case "bool":
				deplacement -= 4;
				break;
			}
		}
	}
	
	public Symbole identifier(Entree entree,int nbligne) throws PasDeDeclarationException{
		Symbole s = tds.get(entree);
		if(s==null){
			throw new PasDeDeclarationException(entree.getEntree() +" n'a pas ete declare!", nbligne);
		}
		return s;
	}
	
	public void verifier(Entree entree, Expression e) throws PasDeDeclarationException{
		Symbole s = tds.get(entree);
		if(s==null){
			if(e == null){
				if(attente.get(entree) == null)
					attente.put(entree, e);
			}else{
				attente.put(entree, e);
			}
		}else{
			if(e != null){
				s.setValeur(e.valeur());
			}
		}
	}
	
	/*public void nonDeclarer() throws PasDeDeclarationException{
		if(!attente.isEmpty()){
			throw new PasDeDeclarationException(attente.entrySet() +" n'a pas été déclaré !", attente.get(attente.entrySet()).getLigne());
		}
	}*/
	
	public void entreeBloc(){
		
	}
	
	public int getDeplacement(Entree entree) throws PasDeDeclarationException{
		Symbole s = tds.get(entree);
		this.identifier(entree,entree.getLigne());
		return s.getDepl();
	}
}
