package plic.arbre.expression;

import plic.exceptions.DivisionParZeroException;
import plic.exceptions.ExecutionException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Div extends BinaireArithmetique {

    public Div(Expression gauche, Expression droite,int nbLigne) {
        super(gauche, droite);
        this.setLigne(nbLigne);
    }

    @Override
    public String operateur() {
        return " / ";
    }

    public int valeur() throws ExecutionException {
    	if (droite.valeur() != 0){
    		return  (gauche.valeur() / droite.valeur());
    	}
    	else
    		throw new DivisionParZeroException("Erreur: Division par zero", ligne);
    		
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
