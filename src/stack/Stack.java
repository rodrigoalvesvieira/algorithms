// Stack (Last in, first out) implementation
// Rodrigo Alves @ CIn/UFPE
// http://en.wikipedia.org/wiki/Stack_(abstract_data_type)

package stack;

class Node {
	Node next;
	char value;
	int numbers;

	public Node(char v) {
		this.next = null;
		this.value = v;
	}

	public Node(int v) {
		this.next = null;
		this.numbers = v;
	}
}

class Stack {
	private Node top;
	private int size;

	public Stack() {
		this.top = null;
		this.size = 0;
	}

	public void addElement(char v) {
		Node newNode = new Node(v);
		if (this.isEmpty()) {
			this.top = newNode;
		} else {
			Node helper;
			helper = newNode;
			helper.next = this.top;
			this.top = newNode;
		}
		this.size++;
	}

	public void addElementNum(int v) {
		Node newNode = new Node(v);
		if (this.isEmpty()) {
			this.top = newNode;
		} else {
			Node helper;
			helper = newNode;
			helper.next = this.top;
			this.top = newNode;
		}
		this.size++;
	}

	public char pop() {
		char value;
		value = this.top.value;
		this.top = this.top.next;
		return value;
	}

	public int popNum() {
		int value;
		value = this.top.numbers;
		this.top = this.top.next;
		return value;
	}

	public char getTopValue() {
		char operator;
		operator = this.top.value;
		return operator;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		if (this.top == null) {
			return true;
		} else {
			return false;
		}
	}
}