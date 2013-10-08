package queue;

class Node {
    int value;
    Node previous;
    Node next;

    public Node(int v) {
        this.value = v;
        this.previous = this.next = null;
    }
    
    public Node(int v, Node prev, Node nxt) {
    	this.value = v;
    	this.previous = prev;
    	this.next = nxt;
    }
}

/**
 * Queue (FIFO) implementation
 * Rodrigo Alves @ CIn/UFPE
 * http://en.wikipedia.org/wiki/Queue_(abstract_data_type)
 * http://en.wikipedia.org/wiki/File:Data_Queue.svg
 */
public class Queue {
    Node back;
    Node front;

    public void enqueue(int v) {
        Node newNode = new Node(v);

        if (this.back == null) {
        	this.back = this.front = newNode;
        } else {
        	newNode.next = this.back;
        	this.back.previous = newNode;
        	this.back = newNode;
		}
	}

    public int dequeue() {
    	if (this.front == null) {
    		return -1;
        } else {
            int res = this.front.value;
            if (this.front.previous != null) this.front.previous.next = null;
            this.front = this.front.previous;
            return res;
        }
    }

    public boolean isEmpty() {
        return this.back == null;
    }

	public int getBack() {
		if (this.back != null) return this.back.value;
		return -1;
	}
	
	public int getFront() {
		if (this.front != null) return this.front.value;
		return -1;
	}
	
	public Node search(int v) {
		boolean go = true;
		Node helper = this.back;
		
		while (go) {
			if (helper.value == v) {
				go = false;
			} else {
				if (helper.next != null) helper = helper.next;
			}
		}
		
		return helper;
	}
	
	public void print() {
		print(this.back);
	}
	
	public void print(Node node) {
		if (node != null) {
			System.out.print(node.value + " ");
			print(node.next);
		} else {
			System.out.println();
		}
	}
	
	public void printReverse() {
		print(this.front);
	}
	
	public void printReverse(Node node) {
		if (node != null) {
			System.out.print(node.value + " ");
			print(node.previous);
		} else {
			System.out.println();
		}
	}
}