package maxHeap;

/**
 *  Max Heap (binary) implementation
 *  
 *  @author Rodrigo Alves @ CIn/UFPE
 *  Based on implementation by Robert Sedgewick and Kevin Wayne at Princeton
 *
 *  http://en.wikipedia.org/wiki/Binary_heap
 *  
 * At any time, the Max Heap must satisfy the heap property:
 * 
 * array[n] >= array[2*n]   // parent element => left child and
 * 
 * array[n] >= array[2*n+1] // parent element => right child
 */
public class MaxHeap {
    private int[] elements;
    int size;

    public MaxHeap(int initCapacity) {
        this.elements = new int[initCapacity + 1];
        this.size = 0;
    }

    public MaxHeap() {
        this(1);
    }

    /**
     * Initializes a priority queue from the array of keys.
     * Takes time proportional to the number of keys, using sink-based heap construction.
     * @param keys the array of keys
     */
    public MaxHeap(int[] keys) {
        size = keys.length;
        this.elements = new int[keys.length + 1]; 
        for (int i = 0; i < size; i++)
        	this.elements[i+1] = keys[i];
        for (int k = size/2; k >= 1; k--)
            sink(k);
        assert isMaxHeap();
    }
    
    /**
     * Is the priority queue empty?
     * @return true if the priority queue is empty; false otherwise
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Returns a largest key on the priority queue.
     * @return a largest key on the priority queue
     */
    public int max() {
        return this.elements[1];
    }

    // helper function to double the size of the heap array
    private void resize(int capacity) {
        assert capacity > size;
        int[] temp = new int[capacity];
        for (int i = 1; i <= this.size; i++) temp[i] = this.elements[i];
        this.elements = temp;
    }

    /**
     * Adds a new key to the priority queue.
     * @param x the new key to add to the priority queue
     */
    public void insert(int x) {
        // double size of array if necessary
        if (size >= elements.length - 1) resize(2 * elements.length);

        // add x, and percolate it up to maintain heap invariant
        elements[++size] = x;
        bubbleUp(size);
        assert isMaxHeap();
    }

    public int extractMax() {
    	int max = elements[1];
        exchange(1, size--);
    	sink(1);
        if ((size > 0) && (size == (elements.length - 1) / 4)) resize(elements.length / 2);
        assert isMaxHeap();
        return max;
    }
    
    private void bubbleUp(int k) {
        while (k > 1 && less(k/2, k)) {
            exchange(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= size) {
            int j = 2*k;
            if (j < size && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return this.elements[i] < this.elements[j];
    }

    private void exchange(int i, int j) {
        int swap = this.elements[i];
        this.elements[i] = this.elements[j];
        this.elements[j] = swap;
    }

    void print() {
        for (int i = 1; i <= size; i++) System.out.print(elements[i] + " ");
        System.out.println();
    }
    
    // is pq[1..N] a max heap?
    private boolean isMaxHeap() {
        return isMaxHeap(1);
    }

    // is subtree of pq[1..N] rooted at k a max heap?
    private boolean isMaxHeap(int k) {
        if (k > size) return true;
        int left = 2*k, right = 2*k + 1;
        if (left  <= size && less(k, left))  return false;
        if (right <= size && less(k, right)) return false;
        return isMaxHeap(left) && isMaxHeap(right);
    }
}