package searching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    // Precondition: array a[] is sorted
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        
        return -1;
    }

    public static void main(String[] args) {
    	int[] col = {1, 2, 3, 4, 5, 6, 7, 10, 20, 40};
    	System.out.println(rank(7, col));
    	
    	System.out.println(rank(40, col));
    	System.out.println(col.length - 1);
    }
}