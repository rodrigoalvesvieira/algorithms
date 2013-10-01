package sorting;

/**
 * Merge sort Algorithm
 * http://en.wikipedia.org/wiki/Merge_sort
 * 
 * Based on implementation by Robert Sedgewick @ Princeton University
 */

public class Merge {

    // stably merge a[lo .. mid] with a[mid+1 .. hi] using aux[lo .. hi]
    public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {

        // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        // copy to aux[]
        for (int k = lo; k <= hi; k++) aux[k] = a[k]; 

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
            	a[k] = aux[j++];
            } else if (j > hi) {
            	a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
            	a[k] = aux[j++];
            } else  {
            	a[k] = aux[i++];
            }
        }

        // postcondition: a[lo .. hi] is sorted
        assert isSorted(a, lo, hi);
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(int[] a) {
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length-1);
        assert isSorted(a);
    }
    
    // is v < w ?
    private static boolean less(int v, int w) {
        return v < w;
    }
        
    // exchange a[i] and a[j]
    private static void exchange(int[] a, int i, int j) {
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
    
    // stably merge a[lo .. mid] with a[mid+1 .. hi] using aux[lo .. hi]
    private static void merge(int[] a, int[] index, int[] aux, int lo, int mid, int hi) {

        // copy to aux[]
        for (int k = lo; k <= hi; k++) aux[k] = index[k];

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
            	index[k] = aux[j++];
            }  else if (j > hi) {
            	index[k] = aux[i++];
            } else if (less(a[aux[j]], a[aux[i]])) {
            	index[k] = aux[j++];
            } else {
            	index[k] = aux[i++];
            }
        }
    }

    // return a permutation that gives the elements in a[] in ascending order
    // do not change the original array a[]
    public static int[] indexSort(int[] a) {
        int N = a.length;
        int[] index = new int[N];
        for (int i = 0; i < N; i++) index[i] = i;

        int[] aux = new int[N];
        sort(a, index, aux, 0, N-1);
        return index;
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(int[] a, int[] index, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, index, aux, lo, mid);
        sort(a, index, aux, mid + 1, hi);
        merge(a, index, aux, lo, mid, hi);
    }

    // print array to standard output
    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
    	int[] a = {88, 1, 40, 23, 11, 99, 70};

    	Merge.sort(a);
        show(a);
    }
}