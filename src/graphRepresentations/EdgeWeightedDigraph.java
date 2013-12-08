package graphRepresentations;

import singlyLinkedList.List;

public class EdgeWeightedDigraph {
	public final int V;
	public int E;
	public List[] Adj;
	
	public EdgeWeightedDigraph(int V) {
		this.V = V;
		this.E = 0;
		Adj = new List[V];
		
		for (int i = 0; i < V; i++) Adj[i] = new List();
	}
}