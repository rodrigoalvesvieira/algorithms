package graphRepresentations;

import doublyLinkedList.List;

/**
 * Simple Graph representation in form of a Adjacency List
 * This is represented by an array of {@link List} objects
 * where each index in the array represents the vertex with its index
 * and each position in the array contains a {@link List} of the vertices
 * that are adjacent to the index
 * 
 * @author Rodrigo Alves
 *
 */
public class SimpleGraph {
	public List[] vertices;
	
	public SimpleGraph(int size) {
		this.vertices = new List[size];
	}
	
	/**
	 * Prints the Adjacent nodes to a given node index at vertices[k]
	 * @param k
	 */
	public void printAdjacent(int k) {
		this.vertices[k].print();
	}
	
	/**
	 * Prints the Graph
	 */
	public void printGraph() {
		for (int i = 0; i < this.vertices.length; i++) {
			System.out.print("Vertex " + i + ": ");
			this.vertices[i].print();
		}
	}
}