// Singly linked list implementation
// Rodrigo Alves @ CIn/UFPE
// http://en.wikipedia.org/wiki/Linked_list

package singlyLinkedList;

class Node {
	Node next;
	int value;

	public Node(int value) {
		this.next = null;
		this.value = value;
	}
}

class List {
	public Node first;
	private int size;
	
	public List() {
		this.first = null;
 	    this.size = 0;
    }
	
	public int getSize() {
		return this.size;
	}
	
	public void push(int v) {
        Node node = new Node(v);
    	
        if (this.isEmpty()) {           
    		this.first = node;
    	} else {
    		Node helper = this.first;
    		
    		while(helper.next != null) {
    			if (helper.next != null) helper = helper.next;
    		}
    		helper.next = node;
    	}
    	
    	this.size++;
    }
	
	public void pushAfter(Node node, int value) {
		Node newNode = new Node(value);
		Node theNext = node.next;
		node.next = newNode;
		newNode.next = theNext;
		this.size++;
	}
	
	public void pop() {
		Node last = this.first;
		Node prev = null;
		
		while (last.next != null) {
			if (last != null) {
				prev = last;
				last = last.next;
			}
		}
		
		prev.next = null;
		last = null;
		this.size--;
	}
	
	public Node search(Node n, int key) {
		if (n == null) return null;
		
		if (n.value == key) {
			return n;
		} else {
			return search(n.next, key);
		}
	}
	
	public boolean isEmpty(){
		return this.size == 0;
	}
	
	public void print() {
		Node helper = this.first;
		
		while(helper != null) {
			System.out.print(helper.value + " ");
			helper = helper.next;
		}
		System.out.println();
	}
}