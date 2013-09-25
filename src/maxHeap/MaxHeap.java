package maxHeap;

/**
 *  Max Heap (binary) implementation
 *  @author Rodrigo Alves @ CIn/UFPE
 *  http://en.wikipedia.org/wiki/Binary_heap
 */
class MaxHeap {
    int[] elements;
    int size;

    public MaxHeap() {
        this.size = 0;
        this.elements = new int[1000];
    }
    
    public MaxHeap(int col) {
    	this.size = 0;
    	this.elements = new int[col];
    }
    
    void bubbleUp() {
    	int i = this.size;
    	while (i > 1 && this.elements[i] >= this.elements[i/2]) {
    		exchange(i, i/2);
    		i = i/2;
    	}
    }

    int parent(int i) {
        return i / 2;
    }

    int left(int i) {
        return 2 * i;
    }

    int right(int i) {
        return 2 * i + 1;
    }
    
    private void exchange(int j, int k) {
    	int swap = this.elements[j];
    	this.elements[j] = this.elements[k];
    	this.elements[k] = swap;
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

    int extract() {
        if (size < 1) return (Integer) null;

        int min = elements[1];
        elements[0] = elements[size - 1];
        elements[size] = (Integer) null;
        size--;
        siftDown(0);
        return min;
    }

    void remove(int v) {
        for (int i = 0; i < size; ++i) {
            if (elements[i] == v) {
                removeAt(i);
                break;
            }
        }
    }

    void removeAt(int where) {
        if (size == 0) return;
        if (where >= size) return;

        if (where == size-1) {
            --size;
            return;
        }
        elements[where] = elements[size-1];
        --size;

        if (where > 0 && Double.compare(elements[where], (elements[(where-1)/2])) > 0) {
            siftUp(where);
        } else if (where < size/2) {
            siftDown(where);
        }
    }

    void siftUp(int i) {
        int par;
        int temp;
        if (i != 0) {
            par = parent(i);
            if (elements[par] > elements[i] || elements[i] == 'F') {
                temp = elements[par];
                elements[par] = elements[i];
                elements[i] = temp;
                siftUp(par);
            }
        }
    }

    void insert(int key) {
        elements[++size] = key;
        siftUp(size);
    }

    boolean empty() {
        return (size == 0);
    }

    void print() {
        for (int i = 1; i < size; i++) System.out.print(elements[i] + " ");
        System.out.println();
    }
};