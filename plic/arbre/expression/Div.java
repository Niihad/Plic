package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Div extends BinaireArithmetique {

    public Div(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " / ";
    }

	@Override
	public String toMips() {
		String division ="";

		//test de la division par 0 a faire
		
		division = this.gauche.toMips()+"\n" + this.droite.toMips()+ "\n" +
		           "	# divise "+this.toString()+"\n"+
		      	   "	add $sp,$sp,4\n"               +	
		      	   "	lw $v0,($sp)\n"                +
		      	   "	add $sp,$sp,4\n"               +
		      	   "	lw $t8,($sp)\n"                +
		      	   "	div $t8,$v0\n"                 +
				   "	mflo $v0\n"                    +
		           "	sw $v0,($sp)\n"                +
		           "	add $sp,$sp,-4\n";
		return division;
		
	}
    
}
