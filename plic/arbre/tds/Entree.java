package plic.arbre.tds;

public class Entree {
	
	protected String idf;
	public int ligne;
	public int colonne;
	
	public Entree(String idf, int ligne, int colonne) {
		this.idf = idf;
		this.ligne = ligne;
		this.colonne = colonne;
	}
	
	public void setEntree(String idf) {
		this.idf = idf;
	}
	
	public String getEntree() {
		return idf;
	}
	
	public boolean equals(Object o) {
		return ((Entree)o).getEntree().equals(idf);
	}
	
	public String toString() {
		return idf;
	}
	
}
