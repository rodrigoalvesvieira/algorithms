// http://www.comp.nus.edu.sg/~stevenha/visualization/heap.html

package maxHeap;

public class Test {
	public static void main(String[] args) {
		Heap h = new Heap();
    	h.insert(10);
    	h.insert(20);
    	h.insert(30);
    	h.insert(40);
    	h.insert(100);
    	h.insert(50);
    	h.insert(60);
    	h.insert(70);
    	h.insert(80);
    	h.insert(90);
    	h.insert(190);
    	
    	h.print();
	}
}