package sorting;

/**
 * Quicksort Algorithm
 * http://en.wikipedia.org/wiki/Quicksort
 * 
 * Based on implementation by Robert Sedgewick @ Princeton University
 * 
 * In the beginning of the execution, let
 * 
 * a[lo] be a[0]
 * a[i] be a[1]
 * a[j] be a[a.length - 1]
 * 
 * Repeat until i and j pointers cross
 * 
 * Scan i from left to right while (a[i] < a[lo])
 * Scan j from right to left so long as (a[j] > a[lo])
 * Exchange a[i] with a[j]
 * 
 * Possible optimization: mix Quicksort and Insertion sort
 * 
 * In sort(int[] a, int lo, int hi) method
 * 
 * if (hi <= lo + CUTOFF - 1) {
 *     Insertion.sort(a, lo, hi);
 *     return;
 * }
 * 
 */
public class Quick {

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    /**
     * Quicksort the subarray from a[lo] to a[hi]
     */
    private static void sort(int[] a, int lo, int hi) { 
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
        assert isSorted(a, lo, hi);
    }

    /**
     * Partition the subarray a[lo .. hi] by returning an index j
     * so that a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
     */
    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) { 

            // find item on lo to swap
            while (less(a[++i], v))
                if (i == hi) break;

            // find item on hi to swap
            while (less(v, a[--j]))
                if (j == lo) break;      // redundant since a[lo] acts as sentinel

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        // put v = a[j] into position
        exch(a, lo, j);

        // with a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

   /***********************************************************************
    *  Rearranges the elements in a so that a[k] is the kth smallest element,
    *  and a[0] through a[k-1] are less than or equal to a[k], and
    *  a[k+1] through a[n-1] are greater than or equal to a[k].
    ***********************************************************************/
    public static int select(int[] a, int k) {
//        StdRandom.shuffle(a);
        
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int i = partition(a, lo, hi);
            if      (i > k) hi = i - 1;
            else if (i < k) lo = i + 1;
            else return a[i];
        }
        return a[lo];
    }

   /***********************************************************************
    *  Helper sorting functions
    ***********************************************************************/
    
    // is v < w ?
    private static boolean less(int v, int w) {
        return (v < w);
    }
    
    /**
     * Exchange a[i] and a[j]
     */
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(int[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i-1])) return false;
        }
        
        return true;
    }

    /**
     * Print array to standard output
     */
    public static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
    	int[] a = {88, 1, 40, 23, 19, 14, 104};
    	
        Quick.sort(a);
        show(a);
        
        if (Quick.isSorted(a)) {
        	System.out.print("It's sorted!");
        }
    }
}