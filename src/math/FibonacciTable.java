package math;

import java.util.Scanner;

/**
 * Fibonacci Table
 * @author Rodrigo Alves
 */
public class FibonacciTable {

	/**
	 * Write an algorithm that receives N and returns a N-sized vector ({@link Array}) of
	 * integers where the element with index i of the array is equal to the Fibonacci of i
	 */
	public static long[] fibonacci(int n) {
		long [] table = new long[n];
		table[0] = 0; // Fib(0) = 0
		table[1] = 1; // Fib(1) = 1
		
		for (int i = 2; i < n; i++) table[i] = table[i-1] + table[i-2];
		return table;
	}
	
	public static long fibonacciOf(int n) {
		return fibonacci(n)[n-1];
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("You want the Fibonacci of:");
		int N = input.nextInt();
		System.out.println(fibonacciOf(N));
		
		System.out.println("You want the first N Fibonacci numbers. Enter N:");
		N = input.nextInt();
		long[] t = fibonacci(N);
		
		for (int i = 0; i < N; i++) System.out.println("Fib(" + i + ") = " + t[i]);
	}
}
