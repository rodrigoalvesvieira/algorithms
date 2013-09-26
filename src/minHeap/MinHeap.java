package minHeap;

/**
 * Min Heap (binary) implementation
 * A type of Priority Queue
 * 
 * @author Rodrigo Alves @ CIn/UFPE
 * 
 * Based on implementation by Robert Sedgewick and Kevin Wayne at Princeton
 * 
 * http://en.wikipedia.org/wiki/Binary_heap
 * 
 * At any time, the Min Heap must satisfy the heap property:
 * 
 * array[n] <= array[2*n]   // parent element <= left child and
 * 
 * array[n] <= array[2*n+1] // parent element <= right child
 */
public class MinHeap {
    private int[] elements;
    int size;
    
    public MinHeap(int initCapacity) {
        this.elements = new int[initCapacity + 1];
        this.size = 0;
    }

    public MinHeap() {
        this(1);
    }

    public MinHeap(int[] keys) {
        size = keys.length;
        elements = new int[keys.length + 1];
        for (int i = 0; i < size; i++)
            this.elements[i+1] = keys[i];
        for (int k = size/2; k >= 1; k--)
            sink(k);
        assert isMinHeap();
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int min() {
        return this.elements[1];
    }

    private void resize(int capacity) {
        assert capacity > size;
        int[] temp = new int[capacity];
        for (int i = 1; i <= size; i++) temp[i] = this.elements[i];
        this.elements = temp;
    }

    public void insert(int x) {
        // double size of array if necessary
        if (size == elements.length - 1) resize(2 * elements.length);

        // add x, and percolate it up to maintain heap invariant
        this.elements[++size] = x;
        swim(size);
        assert isMinHeap();
    }

    /**
     * Removes and returns a smallest key on the priority queue.
     * @return a smallest key on the priority queue
     */
    public int extractMin() {
        exchange(1, size);
        int min = this.elements[size--];
        sink(1);
        if ((size > 0) && (size == (elements.length - 1) / 4)) resize(elements.length  / 2);
        assert isMinHeap();
        return min;
    }

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exchange(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= size) {
            int j = 2*k;
            if (j < size && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }
    
    private boolean greater(int i, int j) {
        return this.elements[i] > this.elements[j];
    }

    private void exchange(int i, int j) {
        int swap = this.elements[i];
        this.elements[i] = this.elements[j];
        this.elements[j] = swap;
    }

    // is pq[1..N] a min heap?
    private boolean isMinHeap() {
        return isMinHeap(1);
    }

    void print() {
        for (int i = 1; i <= size; i++) System.out.print(this.elements[i] + " ");
        System.out.println();
    }
    
    /**
     * Is subtree of elements[1..N] rooted at k a min heap?
     */
    private boolean isMinHeap(int k) {
        if (k > size) return true;
        int left = 2*k, right = 2*k + 1;
        if (left  <= size && greater(k, left))  return false;
        if (right <= size && greater(k, right)) return false;
        return isMinHeap(left) && isMinHeap(right);
    }
}