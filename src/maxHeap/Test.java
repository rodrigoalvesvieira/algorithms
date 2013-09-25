// http://www.comp.nus.edu.sg/~stevenha/visualization/heap.html

package maxHeap;

/**
 * 
 * @author Rodrigo Alves
 *
 */
public class Test {
	public static void main(String[] args) {
		System.out.println("Testing binary Max Heap tree\n");
		MaxHeap heap = new MaxHeap();
		
		int[] inputs = {10, 20, 30, 40, 100, 50, 60, 70, 80, 90, 190};
		for (int i = 0; i < inputs.length; i++) heap.insert(inputs[i]);
	
    	heap.print();
	}
}