package plic.arbre.expression;

import plic.arbre.ArbreAbstrait;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Different extends Comparaison {

    public Different(Expression gauche, Expression droite, int i) {
        super(gauche, droite);
        this.ligne = i;
    }

    @Override
    public String operateur() {
        return " != ";
    }

	@Override
	public String toMips() {
		incCptEtiquette();
		String egal ="";
		egal = this.gauche.toMips()+"\n" + this.droite.toMips()+ "\n" +
				  "	# Compare "+this.toString()+"\n"+
		      	   "	add $sp,$sp,4\n"            +	
		      	   "	lw $v0,($sp)\n"             +
		      	   "	add $sp,$sp,4\n"            +
		      	   "	lw $t8,($sp)\n"             +
		      	   "	beq $v0,$t8 sinon"+ArbreAbstrait.cptEtiquette+"\n" +
				   "	alors"+ArbreAbstrait.cptEtiquette+":\n"            +
		           "	li $v0, 1\n"                + 
		           "	sw $v0,0($sp)\n"            +
		           "	add $sp,$sp,-4\n"           +
		           "	j finsi"+ArbreAbstrait.cptEtiquette+"\n"           + 
		           "	sinon"+ArbreAbstrait.cptEtiquette+":\n"            + 
		           "	li $v0, 0\n"                + 
		       	   "	sw $v0,0($sp)\n"            + 
		           "	add $sp,$sp,-4\n"           +
		       	   "	finsi"+ArbreAbstrait.cptEtiquette+":\n";
		incCptEtiquette();
		return egal;
		
	}

	@Override
	public int valeur() {
		return (gauche.valeur() != droite.valeur()) ? 1 : 0;
	}
  
}
