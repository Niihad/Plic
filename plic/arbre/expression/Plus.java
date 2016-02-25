package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Plus extends BinaireArithmetique {

    public Plus(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " + " ;
    }

	@Override
	public String toMips() {
		String addition = "";
			addition = this.gauche.toMips()+"\n" + this.droite.toMips()+ "\n" +
		           "	# additionne "+this.toString()+" et empile\n"+
		      	   "	add $sp,$sp,4\n"                   +	
		      	   "	lw $v0,($sp)\n"                    +
		      	   "	add $sp,$sp,4\n"                   +
		      	   "	lw $t8,($sp)\n"                    +
		      	   "	add $v0,$v0,$t8\n"                 + 
		           "	sw $v0,($sp)\n"                    +
		           "	add $sp,$sp,-4\n";
		return addition;
		
	}
    

}
