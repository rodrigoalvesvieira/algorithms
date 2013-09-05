// Stack (Last in, first out) implementation
// Rodrigo Alves @ CIn/UFPE
// http://en.wikipedia.org/wiki/Stack_(abstract_data_type)

package stack;

class Node {
	Node prev;
	Node next;
	int value;

	public Node(int value) {
		this.prev = this.next = null;
		this.value = value;
	}
}

class Stack {
	public Node begin;
	public Node top;
	private int size;
	
	public Stack() {
		this.begin = this.top = null;
		this.size = 0;
	}
	
	public void push(int n) {
		Node newNode = new Node(n);
		
		if (this.isEmpty()) {
			this.begin = this.top = newNode;
		} else {
			Node helper = this.top;
			this.top.prev = helper;
			this.top.next = newNode;
			this.top = newNode;
		}
		this.size++;
	}
	
	public int pop() {
		if (!this.isEmpty()) {
			int res = this.top.value;
			
			System.out.println("valor do top: " + this.top.value);
			
			this.top = this.top.prev;

			System.out.println("valor do anterior ao top: " + this.top.prev.value);
			
			this.size--;
			return res;	
		}
		
		return -1;
	}

	public int getSize() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.begin == null;
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
}