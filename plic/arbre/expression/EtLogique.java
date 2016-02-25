package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class EtLogique extends BinaireLogique {

    public EtLogique(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " et " ;
    }
	@Override
	public String toMips() {
		String et ="";
		et = this.gauche.toMips()+"\n" + this.droite.toMips()+ "\n" +
		           "	# Et logique sur "+this.toString()+"\n"+
		      	   "	add $sp,$sp,4\n"  +	
		      	   "	lw $v0,($sp)\n"   +
		      	   "	add $sp,$sp,4\n"  +
		      	   "	lw $t8,($sp)\n"   +
		      	   "	and $v0,$v0,$t8\n"+ 
		           "	sw $v0,($sp)\n"   +
		           "	add $sp,$sp,-4\n";		
		return et;
	}

}
