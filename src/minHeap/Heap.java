package minHeap;

/**
 * Min Heap (binary) implementation
 * A type of Priority Queue
 * 
 * @author Rodrigo Alves @ CIn/UFPE
 * http://en.wikipedia.org/wiki/Binary_heap
 * 
 */
class Heap {
    int[] elements;
    int size;

    public Heap(int hSize) {
        this.size = 0;
        this.elements = new int[hSize];
    }
    
    public int[] children(int i) {
    	int ch[] = {i*2, i*2 + 1};
    	return ch;
    }

    int left(int i) {
        return 2 * i + 1;
    }

    int right(int i) {
        return 2 * i + 2;
    }
    
    int parent(int i) {
        return i / 2;
    }

    void siftDown(int i) {
        int l = left(i);
        int r = right(i);
        int smallest;
        if (l < size && (elements[l] < elements[i])) {
            smallest = l;
        } else {
            smallest = i;
        }
        
        if (r < size && elements[r] < elements[smallest]) smallest = r;

        if (smallest != i) {
            int temp = elements[i];
            elements[i] = elements[smallest];
            elements[smallest] = temp;
            siftDown(smallest);
        }
    }

    int extractMin() {
        if (size < 1) return (Integer) null;
        
        this.exchange(1, this.size);
        int min = this.elements[this.size--];
        siftDown(1);
        return min;
    }

    void siftUp(int i) {
        int parent, temp;
        if (i != 0) {
            parent = parent(i);
            if (elements[parent] > elements[i] || elements[i] == 'F') {
                temp = elements[parent];
                elements[parent] = elements[i];
                elements[i] = temp;
                siftUp(parent);
            }
        }
    }
    
    private void exchange(int j, int k) {
    	int swap = this.elements[j];
    	this.elements[j] = this.elements[k];
    	this.elements[k] = swap;
    }
    
    void insert(int key) {
        this.size++;
        this.elements[size] = key;
        siftUp(this.size);
    }

    boolean empty() {
        return (this.size == 0);
    }

    void print() {
        for (int i = 1; i < this.size; i++) System.out.print(this.elements[i] + " ");
        System.out.println();
    }
};