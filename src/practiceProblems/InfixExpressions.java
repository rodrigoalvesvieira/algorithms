package practiceProblems;

import shared.Arquivo;
import stack.Stack;

/**
 * 
 * Algorithm using Stacks for computing values of Infix Expressions
 * e.g: 3 + 4 * 2
 * @author Rodrigo Alves @ CIn/UFPE
 *
 */
public class InfixExpressions {

	public static void main(String[] args) {
		Stack numbers, operators;
		String expression;
		
		Arquivo file = new Arquivo("./InfixExpressions.txt", "output.txt");
		
		while (!file.isEndOfFile()) {
			numbers = new Stack();
			operators = new Stack();
			expression = "(" + file.readString() + ")";
			
			System.out.println(expression);	
		}
		
	}
}