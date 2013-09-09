/**
 * Dynamic Array data structure
 * http://en.wikipedia.org/wiki/Dynamic_array
 */
package dynamicArray;

public class DynamicArray {
	int[] array;
	int index;
	
	public DynamicArray(int n) {
		this.array = new int[n];
		this.index = 0;
	}
	
	public void push(int n) {
		if (this.array.length == this.index) {
			this.array = copy(this.array);
		} else {
			this.array[index] = n;
			this.index++;	
		}
	}
	
	public int[] copy(int[] A) {
		int i = 0;
		int[] B = new int[A.length * 2];
		
		for (; i < A.length; i++) B[i] = A[i];
		
		return B;
	}
	
	public void print() {
		int i = 0;
		for(; i < this.index; i++) {
			System.out.print(this.array[i] + " ");
		}
		System.out.println();
	}
}