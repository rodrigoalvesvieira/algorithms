package practiceProblems;

import java.util.Arrays;

public class TwoSumFast {
	
	public static int sum(int[] a) {
		int N = a.length;
		Arrays.sort(a);
		int cnt = 0;
		int j;
		
		for (int i = 0; i < N; i++) {
			j = 0;
			
			int k = Arrays.binarySearch(a, -(a[i] + a[j]));
			if (k > j) cnt++;
			j++;
		}
		
		return cnt;
	}
	
	public static void main(String[] args) {
		int a[] = {10, 2, 6, 8, 4};
		
		System.out.println(sum(a));
	
	}

}
