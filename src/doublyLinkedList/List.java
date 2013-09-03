// Doubly linked list implementation
// Rodrigo Alves @ CIn/UFPE
// http://en.wikipedia.org/wiki/Doubly_linked_list

package doublyLinkedList;

class Node {
	Node prev;
	Node next;
	int value;

	public Node(int v) {
		this.prev = null;
		this.next = null;
		this.value = v;
	}
}

class List {
    private Node begin;
    private Node end;
    private int size;
   
    public List() {        
    	this.begin = null;
    	this.end = null;
    	this.size = 0;
    }
   
    public void push(int v){
    	Node node = new Node(v);
    	
    	if (this.isEmpty()) {                    
    		this.begin = node;
    		this.end = node;
    	} else {
    		this.end.next = node;
    		node.prev = this.end;
    		this.end = node;
    	}
    	
    	this.size++;
    }
   
    public void pushStart(int v){
    	Node novoNo = new Node(v);
    	if (this.isEmpty()) {                    
    		this.begin = novoNo;
    		this.end = novoNo;
    	} else {
    		this.begin.prev = novoNo;
    		novoNo.next = this.begin;
    		this.begin = novoNo;
    	}
    	
    	this.size++;
    }
   
    public int getBeginValue(){
    	return this.begin.value;
    }
   
    public int getEndValue(){
    	return this.end.value;
    }
   
    public void removeEnd(){
    	Node helper;
    	helper = this.end.prev;
    	this.end = helper;
    	this.pushStart(this.getEndValue());
    	helper = this.end.prev;
    	this.end = null;
    	this.end = helper;
    	this.size = this.size - 2;         
    }
   
    public void removeBegin(){
    	Node aux;
    	aux = this.begin.next;
    	this.begin = aux;
    	this.push(this.getBeginValue());
    	aux = this.begin.next;
    	this.begin = null;
    	this.begin = aux;
    	this.size = this.size - 2;
    }
   
    public int getSize() {
    	return this.size;
    }

    public boolean isEmpty(){
		if (this.size == 0) return true;
		return false;
	}
    
    public void print() {
		Node helper = this.begin;
		
		while(helper != null) {
			System.out.print(helper.value + " ");
			helper = helper.next;
		}
	}
}