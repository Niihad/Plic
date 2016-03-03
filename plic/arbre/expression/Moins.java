package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Moins extends BinaireArithmetique {

    public Moins(Expression gauche, Expression droite,int nbLigne) {
        super(gauche, droite);
        this.ligne = nbLigne;
        
    }

    @Override
    public String operateur() {
        return " - ";
    }
    
    public int valeur(){
    	return gauche.valeur() - droite.valeur();
    }
    
	@Override
	public String toMips() {
		String soustraction = "";
		soustraction = this.gauche.toMips()+"\n" + this.droite.toMips()+ "\n" +
        "	# soustrait "+this.toString()+"\n"+
        "	add $sp,$sp,4\n"                  +	
   	   	"	lw $v0,($sp)\n"                   +
   	   	"	add $sp,$sp,4\n"                  +
   	   	"	lw $t8,($sp)\n"                   +
   	   	"	sub $v0,$t8,$v0\n"                +
        "	sw $v0,($sp)\n"                   +
        "	add $sp,$sp,-4\n";
		return soustraction;
	}
    
}
