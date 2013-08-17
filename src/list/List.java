// Doubly linked list implementation
// Rodrigo Alves @ CIn/UFPE
// http://en.wikipedia.org/wiki/Doubly_linked_list

package list;

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
   
    public void addElementFim(int v){
    	Node newNode = new Node(v);
    	if (this.isEmpty()) {                    
    		this.begin = newNode;
    		this.end = newNode;
    	} else {
    		this.end.next = newNode;
    		newNode.prev = this.end;
    		this.end = newNode;
    	}
    	
    	this.size++;
    }
   
    public void addElementIni(int v){
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
    	this.addElementIni(this.getEndValue());
    	helper = this.end.prev;
    	this.end = null;
    	this.end = helper;
    	this.size = this.size - 2;         
    }
   
    public void removeBegin(){
    	Node aux;
    	aux = this.begin.next;
    	this.begin = aux;
    	this.addElementFim(this.getBeginValue());
    	aux = this.begin.next;
    	this.begin = null;
    	this.begin = aux;
    	this.size = this.size - 2;
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