package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Superieur extends Comparaison {

    public Superieur(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " > ";
    }
    
    @Override
	public int valeur() {
		boolean res = gauche.valeur() > droite.valeur();
		return (res == true) ? 1 : 0;
	}    

	@Override
	public String toMips() {
		incCptEtiquette();
		int cpt = Expression.cptEtiquette;
		String superieur ="";
		superieur = this.gauche.toMips()+"\n" + this.droite.toMips()+ "\n" +
	           "	# Compare "+this.toString()+"\n"+
	      	   "	add $sp,$sp,4\n"                +
	      	   "	lw $v0,($sp)\n"                 +
	      	   "	add $sp,$sp,4\n"                +
	      	   "	lw $t8,($sp)\n"                 +
	      	   "	sub $v0,$v0,$t8\n"              +
			   "	bgez $v0 sinon"+cpt+"\n"        +
	           "	alors"+cpt+":\n"                +
	           "	li $v0, 1\n"                    + 
	           "	sw $v0,0($sp)\n"                +
	           "	add $sp,$sp,-4\n"               +
	           "	j finsi"+cpt+"\n"               + 
	           "	sinon"+cpt+":\n"                + 
	           "	li $v0, 0\n"                    + 
	       	   "	sw $v0,0($sp)\n"                +  
	           "	add $sp,$sp,-4\n"               +
	       	   "	finsi"+cpt+":\n";
		return superieur;
	}


}
