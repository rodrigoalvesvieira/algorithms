package shared;

import minHeap.MinHeap;

/**
 * Sorting Algorithm based on Binary Min Heap
 * How it works:
 * 
 * For each element k in an unordered array of N elements
 * 1) Insert k into a Binary Min Heap H
 * 2) perform extracMin() on H until H is empty while pushing the extracted element into an helper array
 * 
 * The array is sorted!
 * 
 * @author Rodrigo Alves @ CIn/UFPE
 *
 * Complexity Analysis
 * 
 * Space Complexity:
 * 
 * 2N, where N is the number of elements to be sorted (N for the Heap plus N for the resulting array)
 * Space Complexity is O(2N)
 * Verdict: linear
 *
 * Time Complexity:
 * 
 * N operations to completely fill the Heap (N)
 * N operations to perform minimum extraction (N * log(N))
 * 
 * Time Complexity is O(N + (N * log(n)))
 * Verdict: linearithmic
 */
public class Rodrigosort {
	
	public static void main(String[] args) {
//		Arquivo file = new Arquivo("./inputs/many-integers.txt", "output.txt");
		
		// For compiling via Command Line
		Arquivo file = new Arquivo("../../inputs/many-many-integers.txt", "output.txt");
		
		int N = file.readInt();

//		int[] numbers = {10, 1, 101, 34, 5, 45, 12, 2, 44, 77, 91, 1002, 666};
		
		MinHeap heap = new MinHeap(N);
		
		// Inserting each element in the unordered array into the Min Heap
		for (int i = 0; i < N; i++) heap.insert(file.readInt());
		
		// Creating auxiliary array
		int[] result = new int[N];
		
		// Sequentially performing extracMin() on the Min Heap and adding the extracted element to the auxiliary array
		for (int j = 0; j < N; j++) result[j] = heap.extractMin();
		
		// Printing the sorted array!
		for (int k = 0; k < N; k++) System.out.print(result[k] + ", ");		
	}
}