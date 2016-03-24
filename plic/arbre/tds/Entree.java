package plic.arbre.tds;

public abstract class Entree {
	
	protected String idf;
	public int ligne;
	/*public int colonne;*/
	
	public Entree(String idf, int ligne) {
		this.idf = idf;
		this.ligne = ligne;
	}
	
	public Entree(String idf) {
		this.idf = idf;
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
	
	@Override
	public boolean equals(Object o) {
		return ((Entree) o).getEntree().equals(idf);
	}
	
	@Override
	public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((idf == null) ? 0 : idf.hashCode());
        return result;
    }
	
	public String toString() {
		return idf;
	}
	
}
