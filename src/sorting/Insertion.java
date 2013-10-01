package sorting;

/**
 * Insertion sort Algorithm
 * http://en.wikipedia.org/wiki/Insertion_sort
 * 
 * Based on implementation by Robert Sedgewick @ Princeton University
 */
public class Insertion {

    public static void sort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exchange(a, j, j-1);
            }
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    /**
     * Return a permutation that gives the elements in a[] in ascending order
     * do not change the original array a[]
     */
    public static int[] indexSort(int[] a) {
        int N = a.length;
        int[] index = new int[N];
        for (int i = 0; i < N; i++) index[i] = i;

        for (int i = 0; i < N; i++) {
        	for (int j = i; j > 0 && less(a[index[j]], a[index[j-1]]); j--) {
                exchange(index, j, j-1);        		
        	}
        }
        
        return index;
    }
    
    private static boolean less(int v, int w) {
        return v < w;
    }
        
    private static void exchange(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(int[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    /**
     * Is the array sorted from a[lo] to a[hi]
     */
    private static boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
        	if (less(a[i], a[i-1])) return false;	
        }
        return true;
    }

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
        	System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
    	int[] a = {88, 1, 40, 23, 11, 99, 70};
    	Insertion.sort(a);
    	
    	print(a);
    }
}