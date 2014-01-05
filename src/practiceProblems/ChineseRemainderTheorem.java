package practiceProblems;

import java.util.Scanner;

/**
 * Chinese Remainer Theorem problem solver
 * 
 * @author Rodrigo Alves @ CIn/UFPE
 *
 * Imagine que você tem um problema que consiste em achar um número X tal que:
 * X = 2 (mod 3)
 * X = 3 (mod 5)
 * X = 2 (mod 7)
 * 
 * Pra o programa descobrir a resposta você simplesmente compila ele e entra o seguinte:
 *
 * 2 3
 * 3 5
 * 2 7
 */
public class ChineseRemainderTheorem {

	/**
	 * A = B (mod m) <=> A (mod m) = B (mod m)
	 * Check if A - B (mod m) == 0
	 */
	public static boolean congruent(int a, int b, int m) {
	    return ((a - b) % m) == 0;
	}
	
	public static void main(String[] args) {
		int X, m;
	    int a1, a2, a3;
	    int m1, m2, m3;
	    
	    int M1, M2, M3;
	    int y1, y2, y3;
	    
	    y1 = y2 = y3 = 1;

	    Scanner in = new Scanner(System.in);
	    
	    a1 = in.nextInt();
	    m1 = in.nextInt();
	    a2 = in.nextInt();
	    m2 = in.nextInt();
	    a3 = in.nextInt();
	    m3 = in.nextInt();

	    m = m1 * m2 * m3;

	    M1 = m/m1;
	    M2 = m/m2;
	    M3 = m/m3;
	    
	    /**
	     * k is such that Mk * yk = 1 (mod mk)
	     */

	    for (int i = 1; i <= M1; i++) {
	        if (congruent(M1 * i, 1, m1)) {
	            y1 = i;
	            break;
	        }
	    }
	 
	    for (int i = 1; i <= M2; i++) {
	        if (congruent(M2 * i, 1, m2)) {
	            y2 = i;
	            break;
	        }
	    }
	 
	    for (int i = 1; i <= M3; i++) {
	        if (congruent(M3 * i, 1, m3)) {
	            y3 = i;
	            break;
	        }
	    }
	    
	    X = a1 * M1 * y1 + a2 * M2 * y2 + a3 * M3 * y3;
	    
	    int answer = 1;
	 
	    for (int i = 1; i <= X; i++) {
	        if (congruent(X, i, m)) {
	            answer = i;
	            break;
	        }
	    }
	    
	    System.out.println("A resposta é " + answer);
	    System.out.println("Se a resposta dada não está num intervalo dado pelo problema, apenas adicione "
	                      + m + " à resposta até que esteja");
	}

}