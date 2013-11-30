package graphRepresentations;

class Vertex {
	
	public Vertex() {
		
	}
}

/**
 * Weighted Graph Representation
 * @author Rodrigo Alves @ CIn/UFPE
 *
 */
public class WeightedDigraph {
	private final int V;
	private int E;
	public int[] edges;
	public int[] adj;
	public Vertex[] vertices;
	
	public WeightedDigraph(int V) {
		this.V = V;
		this.E = 0;
		this.edges = new int[1000];
		this.vertices = new Vertex[V];
	}
}