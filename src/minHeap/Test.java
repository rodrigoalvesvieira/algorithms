// http://www.cosc.canterbury.ac.nz/mukundan/dsal/MinHeapAppl.html

package minHeap;

public class Test {
	public static void main(String[] args) {
    	Heap h = new Heap();
    	h.insert(10);
    	h.insert(40);
    	h.insert(4);
    	h.insert(32);
    	h.insert(1);
    	h.insert(2);
    	
    	h.print();
	}
}