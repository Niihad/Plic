package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Different extends Comparaison {

    public Different(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " != ";
    }

	@Override
	public String toMips() {
		incCptEtiquette();
		int cpt = Expression.cptEtiquette;
		String egal ="";
		egal = this.gauche.toMips()+"\n" + this.droite.toMips()+ "\n" +
				  "	# Compare "+this.toString()+"\n"+
		      	   "	add $sp,$sp,4\n"            +	
		      	   "	lw $v0,($sp)\n"             +
		      	   "	add $sp,$sp,4\n"            +
		      	   "	lw $t8,($sp)\n"             +
		      	   "	bne $v0,$t8 sinon"+cpt+"\n" +
				   "	alors"+cpt+":\n"            +
		           "	li $v0, 0\n"                + 
		           "	sw $v0,0($sp)\n"            +
		           "	add $sp,$sp,-4\n"           +
		           "	j finsi"+cpt+"\n"           + 
		           "	sinon"+cpt+":\n"            + 
		           "	li $v0, 1\n"                + 
		       	   "	sw $v0,0($sp)\n"            + 
		           "	add $sp,$sp,-4\n"           +
		       	   "	finsi"+cpt+":\n";
		return egal;
		
	}
  
}
