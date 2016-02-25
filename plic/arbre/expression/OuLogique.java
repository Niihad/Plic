package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class OuLogique extends BinaireLogique {

    public OuLogique(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " ou " ;
    }

	@Override
	public String toMips() {
		String ou = "";
		ou = this.gauche.toMips()+"\n" + this.droite.toMips()+ "\n" +
	           "	# Ou logique sur "+this.toString()+" et empile\n"+
	      	   "	add $sp,$sp,4\n"                   +	
	      	   "	lw $v0,($sp)\n"                    +
	      	   "	add $sp,$sp,4\n"                   +
	      	   "	lw $t8,($sp)\n"                    +
	      	   "	or $v0,$v0,$t8\n"                  + 
	           "	sw $v0,($sp)\n"                    +
	           "	add $sp,$sp,-4\n";
		return ou;	
	}

}
