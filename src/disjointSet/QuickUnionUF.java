package disjointSet;

/**
 * Data Structure (lazy approach)
 * 
 * Integer array id[] of size N
 * Interpretation: id[i] is parent of i
 * 
 * Root of i is id[id[id[...id[i]...]]]
 * 
 */
public class QuickUnionUF {
	int[] id;
	
	/**
	 * Set id of each object to itself
	 */
	public QuickUnionUF(int n) {
		this.id = new int[n];
		for (int i = 0; i < n; i++) id[i] = i;
	}
	
	/**
	 * O(depth of i) array accesses
	 */
	private int root(int i) {
		while(i != this.id[i]) i = id[i];
		return i;
	}
	
	/**
	 * Check if p and q have the same root
	 * O(depth of p and q) array accesses
	 */
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	/**
	 * To merge components containing p and q,
	 * set the id of p's root to the id of q's root
	 *  O(depth of p and q) array accesses
	 */
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}
}