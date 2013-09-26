package maxHeap;

/**
 * @author Rodrigo Alves
 * http://www.comp.nus.edu.sg/~stevenha/visualization/heap.html
 */
public class Test {
	public static void main(String[] args) {
		System.out.println("Testing binary Max Heap\n");
		MaxHeap heap = new MaxHeap();
		
		int[] inputs = {10, 20, 30, 40, 100, 50, 60, 70, 80, 90, 190};
		for (int i = 0; i < inputs.length; i++) heap.insert(inputs[i]);
	
    	heap.print();
    	System.out.println("Heap size is now " + (heap.size) + "\n");
    	
    	System.out.println("Extract max returns " +  heap.extractMax());

    	heap.print();
    	System.out.println("Heap size is now " + (heap.size) + "\n");
    	
    	System.out.println("Inserting 3");
    	heap.insert(3);
    	
    	heap.print();
    	
    	System.out.println("Heap size is now " + (heap.size) + "\n");
    	
    	System.out.println("Extract max returns " +  heap.extractMax());

    	heap.print();
	}
}