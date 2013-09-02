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
	private Node end;
	private int size;
	
	public List() { 
		this.end = null;
 	    this.size = 0;
    }
	
	public int getSize() {
		return this.size;
	}
	
	public void push(int v){
        Node node = new Node(v);
    	
        if (this.isEmpty()) {                    
    		this.end = node;
    	} else {
    		this.end.next = node;
    		node.next = this.end;
    		this.end = node;
    	}
    	
    	this.size++;
    }
	
	public boolean isEmpty(){
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void print() {
		Node helper = this.end;
		
		while(helper != null) {
			System.out.print(helper.value + " ");
			helper = helper.next;
		}
	}
}