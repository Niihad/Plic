package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Mult extends BinaireArithmetique {

    public Mult(Expression gauche, Expression droite,int nbLigne ) {
        super(gauche, droite);
        this.setLigne(nbLigne);
    }
  
    @Override
    public String operateur() {
    	return " * ";
    }

	@Override
	public String toMips() {
		String multiplication ="";
		multiplication = this.gauche.toMips()+"\n" + this.droite.toMips()+ "\n" +
		           "	# multiplie "+this.toString()+"\n"+
		      	   "	add $sp,$sp,4\n" +	
		      	   "	lw $v0,($sp)\n"  +
		      	   "	add $sp,$sp,4\n" +
		      	   "	lw $t8,($sp)\n"  +
		      	   "	mult $v0,$t8\n"  +
				   "	mflo $v0\n"      +
		           "	sw $v0,($sp)\n"  +
		           "	add $sp,$sp,-4\n";		
		return multiplication;
		
	}

}
