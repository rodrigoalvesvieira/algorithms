package minHeap;

/**
 * http://people.ksp.sk/~kuko/bak/index.html
 * @author Rodrigo Alves
 *
 */
public class Test {
	public static void main(String[] args) {
		System.out.println("Testing binary Min Heap\n");

    	MinHeap heap = new MinHeap(20);
    	
		int[] inputs = {10, 20, 30, 40, 100, 50, 60, 70, 80, 90, 190};
		for (int i = 0; i < inputs.length; i++) heap.insert(inputs[i]);
		
		heap.print();
    	System.out.println("Heap size is now " + (heap.size - 1) + "\n");
		    	
    	System.out.println("Extract min returns " +  heap.extractMin());

    	heap.print();
    	System.out.println("Heap size is now " + (heap.size - 1) + "\n");
    	
    	System.out.println("Extract min returns " +  heap.extractMin());

    	heap.print();
    	System.out.println("Heap size is now " + (heap.size - 1) + "\n");
    	
    	System.out.println("Inserting 3");
    	heap.insert(3);

    	heap.print();
    	System.out.println("Heap size is now " + (heap.size - 1) + "\n");
    	
    	System.out.println("Running extractMin() 4 times");
    	heap.extractMin();
    	heap.extractMin();
    	heap.extractMin();
    	
    	int fifty = heap.extractMin();
    	System.out.println("Extracted element was " + fifty +  "\n");
    	heap.print();
    	System.out.println("Heap size is now " + (heap.size - 1) + "\n");
    }
}