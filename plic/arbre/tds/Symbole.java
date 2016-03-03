package plic.arbre.tds;

public class Symbole {
	
	private String statut;
	private String type;
	private int depl;
    
    public Symbole(String statut, String type) {
    	this.statut = statut;
    	this.type = type;
    	//System.out.println(statut +" "+type);
    }
 
    public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
    
    public String toString(){
    	return statut+" "+type;
    }

	public int getDepl() {
		return depl;
	}

	public void setDepl(int depl) {
		this.depl = depl;
	}
}
