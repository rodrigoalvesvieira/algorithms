package math;

import java.util.Scanner;

/**
 * @author Rodrigo Alves @ CIn/UFPE
 */
public class FactorialTable {

	/**
	 * Write an algorithm that receives N and returns a N-sized vector ({@link Array}) of
	 * integers where the element with index i of the array is equal to i! 
	 */
	public static long[] factorial(int n) {
		long [] table = new long[n];
		table[0] = 1; // 0! = 1
		
		for (int i = 1; i < n; i++) table[i] = i * table[i-1];
		return table;
	}
	
	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt();
		
		long[] t = factorial(N);
		
		for (int i = 0; i < N; i++) System.out.println(i + "! = " + t[i]);
	}
}