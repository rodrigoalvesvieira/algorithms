package sorting;

/**
 * Bubble sort Algorithm
 * http://en.wikipedia.org/wiki/Bubble_sort
 * 
 * @author Rodrigo Alves @ CIn/UFPE
 */
public class Bubble {
	
	public static void sort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = a.length - 1; j > i; j--) {
				if (a[j] < a[j-1]) exchange(a, j, j-1);
			}
		}
	}
	
	// exchange a[i] and a[j]
    private static void exchange(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
	// print array to standard output
	public static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
    }
	
	public static void main(String[] args) {
    	int[] a = {88, 1, 40, 23, 11, 99, 70, 12, 4, 77, 101};
    	Bubble.sort(a);
    	
    	Bubble.show(a);
	}
}