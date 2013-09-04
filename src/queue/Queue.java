// Queue (FIFO) implementation
// Rodrigo Alves @ CIn/UFPE
// http://en.wikipedia.org/wiki/Queue_(data_structure)

package queue;

class Node {
    int value;
    Node next;

    public Node(int v) {
        this.value = v;
        this.next = null;
    }
}

class Queue {
    Node top;

    public void enqueue(int v) {
        Node newNode = new Node(v);

        if (this.top == null) {
        	this.top = newNode;
        } else {
        	Node helper = this.top;
        	while (helper.next != null) {
		    	if (helper.next != null) helper = helper.next;
		    }
        	helper.next = newNode;		    
		}
	}

    public int dequeue() {
    	if (top == null) {
    		return -1;
        } else {
            int res = this.top.value;
            this.top = this.top.next;
            return res;
        }
    }

    public boolean isEmpty() {
        return this.top == null;
    }

	public int getTop() {
		if (top != null) return top.value;
		return -1;
	}

	public int getLastElement() {
		while (top.next != null) {
			top = top.next;
		}
		
		return this.top.value;
	}
	
	public void print() {
		print(this.top);
	}
	
	public void print(Node node) {
		if (node != null) {
			System.out.print(node.value + " ");
			print(node.next);
		} else {
			System.out.println();
		}
	}
}