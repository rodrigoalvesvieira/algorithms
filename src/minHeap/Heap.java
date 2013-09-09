// Min Heap (binary) implementation
// Rodrigo Alves @ CIn/UFPE
// http://en.wikipedia.org/wiki/Binary_heap

package minHeap;

class Heap {
    int[] heap;
    int size;

    public Heap() {
        this.size = 0;
        this.heap = new int[1000];
    }

    int parent(int i) {
        if (i % 2 == 0) {
            return (i - 2) / 2;
        } else {
            return (i - 1) / 2;
        }
    }

    int left(int i) {
        return 2 * i + 1;
    }

    int right(int i) {
        return 2 * i + 2;
    }

    void siftDown(int i) {
        int l = left(i);
        int r = right(i);
        int smallest;
        if (l < size && (heap[l] < heap[i])) {
            smallest = l;
        } else {
            smallest = i;
        }
        
        if (r < size && heap[r] < heap[smallest]) smallest = r;

        if (smallest != i) {
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;
            siftDown(smallest);
        }
    }

    int extract() {
        if (size < 1) return (Integer) null;

        int min = heap[0];
        this.heap[0] = this.heap[size - 1];
        this.heap[size] = (Integer) null;
        this.size--;
        siftDown(0);
        return min;
    }

    void remove(int v) {
        for (int i = 0; i < size; ++i) {
            if (heap[i] == v) {
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
        heap[where] = heap[size-1];
        --size;

        if (where > 0 && Double.compare(heap[where], (heap[(where-1)/2])) > 0) {
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
            if (heap[par] > heap[i] || heap[i] == 'F') {
                temp = heap[par];
                heap[par] = heap[i];
                heap[i] = temp;
                siftUp(par);
            }
        }
    }

    void insert(int key) {
        this.size++;
        this.heap[size - 1] = key;
        siftUp(this.size - 1);
    }

    boolean empty() {
        return (this.size == 0);
    }

    void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.heap[i] + " ");
        }
        
        System.out.println();
    }
};