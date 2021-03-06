package plic.instructions;

import plic.arbre.BlocDInstructions;
import plic.arbre.expression.Expression;
import plic.exceptions.PasDeDeclarationException;
import plic.exceptions.SemantiqueException;

public class EcrireExpression extends BlocDInstructions {

	private Expression expression;
	
	public EcrireExpression(Expression exp){
		super();
		this.expression = exp;
	}
	
	@Override
	public void verifier() throws SemantiqueException {
		expression.verifier();
	}	
	

	@Override
	public String toMips() throws PasDeDeclarationException {
		StringBuilder ecrire = new StringBuilder();
		ecrire.append("	# Ecrire "+expression.toString()+"\n");	
		ecrire.append(	expression.toMips()+"\n");
		ecrire.append("	add $sp,$sp,4 \n");
		ecrire.append("	li $v0, 1 \n");
		ecrire.append("	lw $a0,($sp) \n");
		ecrire.append("	syscall\n");
				
		return ecrire.toString() ;
	}

	@Override
	public String toString() {
		return "Ecriture de l'expression "+expression+", valeur: "+expression.valeur();
	}

}
