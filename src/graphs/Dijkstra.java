package graphs;

import minHeap.MinHeap;

import stack.Stack;
import singlyLinkedList.List;

import shared.Arquivo;

/**
 * Implementation of Dijkstra's shortest path algorithm
 * http://en.wikipedia.org/wiki/Dijkstra's_algorithm
 * 
 * O(|E| + |V| log |V|) cost
 * 
 * @author Rodrigo Alves @ CIn/UFPE
 */
public class Dijkstra {
	private static long INFINITY = 1000000000;
	
	private int[] distanceTo;
	public MinHeap pq;
	
	public Dijkstra(List[] graph, int s) {
		this.distanceTo = new int[1000];
		this.pq = new MinHeap();
	}
	
	public boolean pathExists(int v) {
		return this.distanceTo[v] < INFINITY;
	}

	public static void main(String[] args) {
		Arquivo file = new Arquivo("./inputs/Dijkstra.txt", "output.txt");

		int T, N, M, S, A, C;
		
		T = file.readInt();
		System.out.println(T);
		
	    N = file.readInt();
		M = file.readInt();
		
	    S = file.readInt();
	    A = file.readInt();
	    
	    C = file.readInt();
	    
		System.out.println(N + " - " + M);
		System.out.println(S + " - " + A);
		
		while (N > 0) {
			N--;
		}
	}
}