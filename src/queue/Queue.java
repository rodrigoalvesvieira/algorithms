// Queue implementation
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
		    this.top.next = newNode;
		}
	}

    public int dequeue() {
    	if (top == null) {
    		return -1;
        } else {
            Node current = top.next;
            Node previous = top;
            int v = 0;

            if (previous.next == null) {
                v = top.value;
                top = null;
                return v;
            } else {
                while (current.next != null) {
                    current = current.next;
                    previous = previous.next;
                }

                v = current.value;
                previous.next = null;
                return v;
            }
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
		}
	}
}