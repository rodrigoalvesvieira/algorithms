package graphs;

import queue.Queue;
import shared.Arquivo;

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

/**
 * Simple implementation of a BFS https://en.wikipedia.org/wiki/Breadth-first_search
 * https://upload.wikimedia.org/wikipedia/commons/3/33/Breadth-first-tree.svg
 * 
 * A translation from C++ from the original at https://gist.github.com/rodrigoalvesvieira/6148834
 * 
 * Time complexity is O(|V| + |E|). According to Wikipedia O(|E|) may vary from O(|V|) to O(|V|^2).
 * @author Rodrigo Alves
 *
 */
public class BFS {
	
	public static void printGraph(List[] Adj) {
		int N = Adj.length;
		for (int i = 0; i < N; i++) {
			Adj[i].print();
		}
	}

	public static void main(String[] args) {
		Arquivo file = new Arquivo("./inputs/BFS.txt", "output.txt");
		
		int T, N, Q, E, x, vertex; boolean empty;
		T = file.readInt();
		
		while (T > 0) {
			N = file.readInt();
			
			int j = 0, t;
			int[] marked;
			List[] Adj = new List[N];
			
			for (int p = 0; p < N; p++) Adj[p] = new List();
			
			for (int i = 0; i < N; i++) {
				Q = file.readInt();

				while (Q > 0) {
					x = file.readInt();
					Adj[i].push(x);
					Q--;
				}
			}
			
//			printGraph(Adj);
			E = file.readInt();
			Queue A = new Queue();
			
			while (E > 0) {
				marked = new int[N];
				vertex = file.readInt();
				
				System.out.println("Vertex to be enqueued is " + vertex);
				
				A.enqueue(vertex);
				A.print();
				
				marked[vertex] = 1;
				empty = false;
				
//				while (!A.isEmpty()) {
//					if (Adj[vertex].isEmpty()) {
//						empty = true;
//						break;
//					}
					
//					System.out.println(A.size);
					
//					t = A.dequeue();
//					System.out.println("t é " + t);
					
					/*
//					Node helper = Adj[t].first;
//					
// 					while (helper != null) {
//						if (!marked[helper.value]) {
//							marked[helper.value] = 1;
//							A.enqueue(helper.value);
//						}
//						
//						helper = helper.next;
//					}
//					*/
//				}
				
				E--;
			}
						
			T--;
		}
	}
}