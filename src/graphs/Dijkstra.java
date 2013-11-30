package graphs;

import graphRepresentations.WeightedDigraph;
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
 * 
 * Based on:
 * 
 * http://algs4.cs.princeton.edu/42directed/
 * http://algs4.cs.princeton.edu/44sp/EdgeWeightedDigraph.java.html
 * http://algs4.cs.princeton.edu/13stacks/Bag.java.html
 * http://algs4.cs.princeton.edu/44sp/DijkstraSP.java.html
 * 
 * Animations & Illustrations:
 * 
 * http://www.dgp.toronto.edu/people/JamesStewart/270/9798s/Laffra/DijkstraApplet.html
 * http://students.ceid.upatras.gr/~papagel/english/java_docs/minDijk.htm
 * http://www.unf.edu/~wkloster/foundations/DijkstraApplet/DijkstraApplet.htm
 * 
 */
public class Dijkstra {
	public WeightedDigraph graph;
	private static long INFINITY = 1000000000;
	
	private int[] distanceTo;
	public MinHeap pq;
	
	public Dijkstra(WeightedDigraph graph, int s) {
		this.distanceTo = new int[1000];
		this.pq = new MinHeap();
		
//		for (int i = 0; i < graph.vertices.length; i++);

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