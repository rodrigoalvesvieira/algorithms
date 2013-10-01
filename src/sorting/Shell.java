package sorting;

/**
 * Shellsort Algorithm
 * http://en.wikipedia.org/wiki/Shellsort
 * 
 * Based on implementation by Robert Sedgewick @ Princeton University
 */
public class Shell {

    // sort the array a[] in ascending order using Shellsort
    public static void sort(int[] a) {
        int N = a.length;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ... 
        int h = 1;
        while (h < N/3) h = 3*h + 1; 

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exchange(a, j, j-h);
                }
            }
            assert isHsorted(a, h); 
            h /= 3;
        }
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
        for (int i = 1; i < a.length; i++) {
        	if (less(a[i], a[i-1])) return false;
        }
        
        return true;
    }

    // is the array h-sorted?
    private static boolean isHsorted(int[] a, int h) {
        for (int i = h; i < a.length; i++) {
        	if (less(a[i], a[i-h])) return false;	
        }
        return true;
    }

    // print array to standard output
    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
    	int[] a = {88, 1, 40, 23, 11, 99, 70};
        Shell.sort(a);
        
        print(a);
    }
}