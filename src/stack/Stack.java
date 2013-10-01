// Stack (Last in, first out) implementation
// Rodrigo Alves @ CIn/UFPE
// http://en.wikipedia.org/wiki/Stack_(abstract_data_type)

package stack;

class Node {
	Node previous;
	Node next;
	int value;

	public Node(int value) {
		this.previous = this.next = null;
		this.value = value;
	}
}

public class Stack {
	public Node top;
	public Node begin;
	int size;
	
	public Stack() {
		this.begin = this.top = null;
		this.size = 0;
	}
	
	public void push(int v) {
		Node newNode = new Node(v);
		
		if (this.isEmpty()) {
			this.begin = this.top = newNode;
		} else {
			this.top.next = newNode;
			newNode.previous = this.top;
			this.top = newNode;
		}
		
		this.size++;
	}
	
	public int pop() {
		if (!this.isEmpty()) {
			int res = this.top.value;
			
			this.top = this.top.previous;
			this.top.next = null;
			
			this.size--;
			return res;	
		}
		
		return -1;
	}

	public boolean isEmpty() {
		return this.top == null;
	}
	
	public void print() {
		print(this.begin);
	}
	
	public void print(Node node) {
		if (node != null) {
			System.out.print(node.value + " ");
			print(node.next);
		} else {
			System.out.println();
		}
	}
	
	public Node search(Node n, int key) {
		if (n == null) return null;
		
		if (n.value == key) {
			return n;
		} else {
			return search(n.next, key);
		}
	}
}