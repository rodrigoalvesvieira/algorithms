package practiceProblems;
import java.util.Arrays;

/**
 * 
 * Sieve of Eratosthenes implementation
 * http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 * 
 * @author Rodrigo Alves
 *
 */
public class SieveEratosthenes {
	
	public static boolean[] sieve(int n, boolean[] prime) {
	   Arrays.fill(prime, true);
	   prime[0] = prime[1] = false;
	   
	   for (int i = 2; i <= (int) Math.sqrt(n); i++) {
	      if (prime[i]) {
	         for (int k= i*i; k <= n; k += i) prime[k]=false;
	      }
	   }

	   return prime;
	}

	public static void main(String[] args) {
		boolean prime[] = new boolean[100];
		sieve(99, prime);
		
		for (int i = 0; i < 100; i++) System.out.println(i + " - " + prime[i]);
	}
}