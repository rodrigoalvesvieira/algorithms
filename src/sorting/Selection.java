package sorting;

/**
 * Selection sort Algorithm
 * http://en.wikipedia.org/wiki/Selection_sort
 * 
 * Based on implementation by Robert Sedgewick @ Princeton University
 */
public class Selection {

    public static void sort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exchange(a, i, min);
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
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
    
    // is the array sorted from a[lo] to a[hi]
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
    	int[] a = {88, 1, 40, 23};
    	
        Selection.sort(a);
        print(a);
    }
}