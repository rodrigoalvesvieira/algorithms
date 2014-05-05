package math;

import java.util.Scanner;

/**
 * Finds the Greatest Common Divisor (GCD)
 * http://en.wikipedia.org/wiki/Greatest_common_divisor
 * 
 * @author Rodrigo Alves
 *
 */
public class GCD {

	public static int GCD(int a, int b) {
	   if (b == 0) return a;
	   return GCD(b, a%b);
	}
	
	public static int LCM(int a, int b) {
	   return b*a/GCD(a, b);
	}
	
	public static void main(String[] args) {
		System.out.println("Enter integers A and B");

		Scanner io = new Scanner(System.in);
		int A, B;
		
		A = io.nextInt();
		B = io.nextInt();
		
		System.out.println(GCD(A, B));
	}
}