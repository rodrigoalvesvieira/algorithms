package graphs;

import queue.Queue;
import minHeap.MinHeap;
import graphRepresentations.WeightedGraph;

/**
 * Kruskal Minimum Spanning Tree algorithm implementation
 * 
 * @author Rodrigo Alves
 * Based on http://algs4.cs.princeton.edu/43mst/KruskalMST.java.html
 * 
 */
public class KruskalMST {
	double weight;
	Queue mst = new Queue();
	
	public KruskalMST(WeightedGraph G) {
		MinHeap pq = new MinHeap();
		
		for (int e: G.edges) pq.insert(e);
		
	}
	
	public static void main(String[] args) {
		
	}

}