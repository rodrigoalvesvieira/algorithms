/**
 * Testing Disjoint Sets data structure
 * http://algs4.cs.princeton.edu/15uf/
 */
package disjointSet;

public class Test {
	public static void main(String[] args) {
		System.out.println("Testing Union Find\n");

		int N = 100;
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
		
		int p = 10, q = 12;
//		if (uf.connected(p, q)) continue;
		
		uf.union(p, q);
		System.out.println(p + " " + q);
			
		System.out.println(uf.count() + " components");
	}
}