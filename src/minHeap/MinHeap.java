package minHeap;

/**
 * Min Heap (binary) implementation
 * A type of Priority Queue
 * 
 * @author Rodrigo Alves @ CIn/UFPE
 * 
 * Based on implementation by Robert Sedgewick and Kevin Wayne at Princeton
 * http://en.wikipedia.org/wiki/Binary_heap
 * 
 * At any time, the Min Heap must satisfy the heap property:
 * 
 * array[n] <= array[2*n]     // parent element <= left child and
 * array[n] <= array[2*n+1]   // parent element <= right child
 * 
 * In other words:
 * 
 * A[Parent(i)] <= A[i]
 * 
 * Other properties:
 * 
 * Let i be an index for a node in the Heap, then:
 * 
 * floor(i / 2) represents the parent element of i
 * 2 * 1 represents the left child of i
 * 2 * 1 + 1 represents the right child of i
 * 
 * More Heap facts (From Cormen book):
 * 
 * Let A be the array that represents a given Heap
 * A.length gives the number of elements in the array,
 * and A.heap_size gives how many elements of the heap
 * are stored within A.
 * 
 * That is, although A[1..A.length] may contain numbers, only
 * the elements in A[1..A.heap_size], where 0 <= A.heap_size <= A.length are valid elements of the heap.
 * 
 * Maximum number of elements in a heap of height H is : 2^(H+1) - 1
 * Minimum number of elements in a heap of height H is : 2^H
 * 
 * An array sorted in increasing order is a Min Heap
 */
public class MinHeap {
    private int[] elements;
    int heapSize;
    
    public MinHeap(int initCapacity) {
        this.elements = new int[initCapacity + 1];
        this.heapSize = 0;
    }

    public MinHeap() {
        this(1);
    }

    public MinHeap(int[] keys) {
        heapSize = keys.length;
        elements = new int[keys.length + 1];
        for (int i = 0; i < heapSize; i++)
            this.elements[i+1] = keys[i];
        for (int k = heapSize/2; k >= 1; k--)
            sink(k);
        assert isMinHeap();
    }

    public boolean isEmpty() {
        return this.heapSize == 0;
    }

    public int min() {
        return this.elements[1];
    }

    private void resize(int capacity) {
        assert capacity > heapSize;
        int[] temp = new int[capacity];
        for (int i = 1; i <= heapSize; i++) temp[i] = this.elements[i];
        this.elements = temp;
    }

    public void insert(int x) {
        // double size of array if necessary
        if (heapSize == elements.length - 1) resize(2 * elements.length);

        // add x, and percolate it up to maintain heap invariant
        this.elements[++heapSize] = x;
        swim(heapSize);
        assert isMinHeap();
    }

    /**
     * Removes and returns a smallest key on the priority queue.
     * @return a smallest key on the priority queue
     */
    public int extractMin() {
        exchange(1, heapSize);
        int min = this.elements[heapSize--];
        sink(1);
        if ((heapSize > 0) && (heapSize == (elements.length - 1) / 4)) resize(elements.length  / 2);
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
        while (2*k <= heapSize) {
            int j = 2*k;
            if (j < heapSize && greater(j, j+1)) j++;
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
        for (int i = 1; i <= heapSize; i++) System.out.print(this.elements[i] + " ");
        System.out.println();
    }
    
    /**
     * Is subtree of elements[1..N] rooted at k a min heap?
     */
    private boolean isMinHeap(int k) {
        if (k > heapSize) return true;
        int left = 2*k, right = 2*k + 1;
        if (left  <= heapSize && greater(k, left))  return false;
        if (right <= heapSize && greater(k, right)) return false;
        return isMinHeap(left) && isMinHeap(right);
    }
}