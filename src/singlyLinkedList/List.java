// Singly linked list implementation
// Rodrigo Alves @ CIn/UFPE
// http://en.wikipedia.org/wiki/Linked_list

package singlyLinkedList;

class Node {
	Node next;
	int value;

	public Node(int v) {
		this.next = null;
		this.value = v;
	}
}

class List {
	private Node begin;
	private int size;
	
	public List() {        
		this.begin = null;
 	    this.size = 0;
    }
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty(){
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}
}