/**
 * Testing Disjoint Sets data structure
 * http://algs4.cs.princeton.edu/15uf/
 */
package disjointSet;

public class Test {
	public static void main(String[] args) {
		System.out.println("Testing Union Find\n");

		// As taught by Professor Paulo Gustavo, n disjoint sets can be united with n-1 union operations
		// Thus 128 elements should be united after 127 union operations
		
		int NumElements = 128;  // 128 elements in the set
	    int NumInSameSet = 128; // all 128 are disjoint
	    int sumOperations  = 0; // sum of operations must then equal 127

	    DisjointSet s = new DisjointSet(NumElements);
	    int set1, set2;

	    for (int k = 1; k < NumInSameSet; k *= 2) {	    	
	        for (int j = 0; j + k < NumElements; j += 2 * k) {
	        	set1 = s.find(j);
	        	set2 = s.find(j + k);
	        	s.union(set1, set2);
	        	sumOperations++;
	        }
	    }
	    
	    System.out.println("Sum is " + sumOperations); // Fuck yeah, 127
	    
	    for (int i = 0; i < NumElements; i++) {
//	    	System.out.print(s.find(i) + "*");
	    	if (i % NumInSameSet == NumInSameSet - 1) System.out.println();
	    }
	    
	    System.out.println();
	}
}