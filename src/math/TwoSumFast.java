package math;

import java.util.Arrays;

/**
 * Fast implementation of the 2-Sum Algorithm using Binary Search
 * @author Rodrigo Alves @ CIn/UFPE
 *
 */
public class TwoSumFast {
	
	public static int sum(int[] a) {
		int j, k, N = a.length, cnt = 0;
		Arrays.sort(a);
		
		for (int i = 0; i < N; i++) {
			j = 0;
			
			k = Arrays.binarySearch(a, -(a[i] + a[j]));
			if (k > j) cnt++;
			j++;
		}
		
		return cnt;
	}
	
	public static void main(String[] args) {
		int a[] = {10, 2, 6, 8, 4, 12};
		
		System.out.println(sum(a));
	}
}