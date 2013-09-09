// Max Heap (binary) implementation
// Rodrigo Alves @ CIn/UFPE
// http://en.wikipedia.org/wiki/Binary_heap

package maxHeap;

class Heap {
    int[] collection;
    int size;
    int currentIndex = 0;

    public Heap() {
        this.size = 0;
        this.collection = new int[1000];
    }
    
    public Heap(int col) {
    	this.size = 0;
    	this.collection = new int[col];
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
        
        if (l < size && (collection[l] < collection[i])) {
            smallest = l;
        } else {
            smallest = i;
        }
        if (r < size && collection[r] < collection[smallest]) smallest = r;

        if (smallest != i) {
            int temp = collection[i];
            collection[i] = collection[smallest];
            collection[smallest] = temp;
            siftDown(smallest);
        }
    }

    int extract() {
        if (size < 1) return (Integer) null;

        int min = collection[0];
        collection[0] = collection[size - 1];
        collection[size] = (Integer) null;
        size--;
        siftDown(0);
        return min;
    }

    void remove(int v) {
        for (int i = 0; i < size; ++i) {
            if (collection[i] == v) {
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
        collection[where] = collection[size-1];
        --size;

        if (where > 0 && Double.compare(collection[where], (collection[(where-1)/2])) > 0) {
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
            if (collection[par] > collection[i] || collection[i] == 'F') {
                temp = collection[par];
                collection[par] = collection[i];
                collection[i] = temp;
                siftUp(par);
            }
        }
    }

    void insert(int key) {
        size++;
        collection[size - 1] = key;
        siftUp(size - 1);
    }

    boolean empty() {
        return (size == 0);
    }

    void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(collection[i] + " ");
        }
        
        System.out.println();
    }
};