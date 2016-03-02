package plic.arbre.tds;

public class Entree {
	
	protected String idf;
	public int ligne;
	/*public int colonne;*/
	
	public Entree(String idf, int ligne) {
		this.idf = idf;
		this.ligne = ligne;
	}
	
	public Entree(String idf) {
		this.idf = idf;
		this.ligne = 0;
	}
	
	public void setEntree(String idf) {
		this.idf = idf;
	}
	
	public String getEntree() {
		return idf;
	}
	
	public int getLigne(){
		return ligne;
	}
	
	public boolean equals(Object o) {
		return ((Entree)o).getEntree().equals(idf);
	}
	
	public String toString() {
		return idf;
	}
	
}
