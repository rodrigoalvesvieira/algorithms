package treeSum;

/**
 * Naive, brute-force O(n^3) solution for the classic 3-Sum problem from
 * Complexity Theory and Computational Geometry:
 * http://en.wikipedia.org/wiki/3SUM
 * 
 * By Robert Sedgewick in the Algorithms I Course at Princeton U
 *
 */
public class TreeSum {
	public static int count(int[] a) {
		int N = a.length;
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				for(int k = j+1; k < N; k++) {
					if (a[i] + a[j] + a[k] == 0) count++;
				}
			}
		}
		
		return count;
	}
}