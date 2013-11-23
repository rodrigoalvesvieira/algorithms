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
    int size;
   
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
    	Node node = new Node(v);
    	if (this.isEmpty()) {                    
    		this.begin = node;
    		this.end = node;
    	} else {
    		this.begin.prev = node;
    		node.next = this.begin;
    		this.begin = node;
    	}
    	this.size++;
    }
    
    public void pop(int v) {
    	Node helper = this.begin;
    	
    	while (helper != null) {
    		if (helper.value == v) {
    			if (helper.prev != null) {
    				helper.prev.next = helper.next;
    			} else {
    				System.out.println("caiu no else. nao eh nulo!");
    				System.out.println("helper eh " + helper.value + 
    						" e seu prev eh " + helper.prev + " e seu next eh " + helper.next.value);
    				
    				helper.prev = helper.next;
    			}
    			
    			helper = null;
    			break;
    		}
    		
    		helper = helper.next;
    	}
    }
   
    public int getBeginValue(){
    	return this.begin.value;
    }
   
    public int getEndValue(){
    	return this.end.value;
    }
   
    public void removeEnd(){
    	this.end.prev.next = null;
    	this.end = this.end.prev;
    	this.size--;
    }
   
    public void removeBegin(){
    	this.begin.next.prev = null;
    	this.begin = this.begin.next;
    	this.size--;
    }
   
    public int getSize() {
    	return this.size;
    }

    public boolean isEmpty(){
		return this.size == 0;
	}
    
    public void print() {
		Node helper = this.begin;
		
		while(helper != null) {
			System.out.print(helper.value + " ");
			helper = helper.next;
		}
		System.out.println();
	}
}