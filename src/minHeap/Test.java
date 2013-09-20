package minHeap;

/**
 * http://people.ksp.sk/~kuko/bak/index.html
 * @author Rodrigo Alves
 *
 */
public class Test {
	public static void main(String[] args) {
		System.out.println("Testing binary Min Heap tree\n");

    	Heap heap = new Heap(1000);
    	int numbers[] = {10, 40, 4, 32, 1, 2, 21, 666, 7, 33};
    	
    	for (int i = 0; i < numbers.length; i++) heap.insert(numbers[i]);
    	heap.print();
    	System.out.println("Heap size is now " + heap.size + "\n");
    	
    	System.out.println("first element is " + heap.elements[1] + "\n");
    	
    	System.out.println("Extract min returns " +  heap.extractMin());
    	heap.print();
    	
    	System.out.println("Heap size is now " + heap.size + "\n");
	}
}