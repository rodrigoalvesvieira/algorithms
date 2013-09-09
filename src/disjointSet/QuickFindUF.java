package disjointSet;

/**
 * Data Structure (eager approach)
 * 
 * Integer array id[] of size N
 * Interpretation: p and q are connected <=> they have the same id
 * indexes {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
 * id[] =  {0, 1, 1, 8, 8, 0, 0, 1, 8, 8}
 *     
 * In the example above:
 * 0 and 5 are connected
 * 1, 2 and 7 are connected
 * 3, 4, 8 and 9 are connected
 * 
 * Quick-find is too expensive. Union is too expensive.
 * In particular:
 *
 * If you have n union commands on n objects you'll end up with N^2 array accesses
 */
public class QuickFindUF {
	int[] id;
	
	/**
	 * Set id of each object to itself at O(n) cost
	 */
	public QuickFindUF(int n) {
		this.id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}
	
	/**
	 * Check whether p and q are in the same component at O(1) cost
	 *  
	 * A connection is an equivalence relation:
	 * 
	 * Reflexive: p is connected to p
	 * Symmetric: if p is connected to q, then q is connected to p
	 * Transitive: if p is connected to q, and q is connected to r, then p is connected to r
	 */
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}
	
	/**
	 * Change all entries with id p to id q at O(2n + 2) cost
	 */
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		
		int i = 0;
		for (; i < id.length; i++) {
			if (id[i] == pid) id[i] = qid;
		}
	}
}