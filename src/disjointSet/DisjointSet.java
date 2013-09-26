package disjointSet;

/**
 * Disjoint Set (union-find) data-structure implementation
 * http://en.wikipedia.org/wiki/Disjoint-set_data_structure
 * 
 * Based on implementation by Mark Allen Weiss
 */
public class DisjointSet {
	int[] elements;

    /**
     *  @param numElements the initial number of disjoint sets. Every element is initially in its own set
     **/
    public DisjointSet(int numElements) {
	    this.elements = new int [numElements];
	    for (int i = 0; i < this.elements.length; i++) this.elements[i] = -1;
    }

    /**
     *  union() unites two disjoint sets into a single set.  A union-by-rank
     *  heuristic is used to choose the new root.  This method will corrupt
     *  the data structure if root1 and root2 are not roots of their respective
     *  sets, or if they're identical.
     *
     *  @param root1 the root of the first set.
     *  @param root2 the root of the other set.
     **/
    public void union(int root1, int root2) {
	    if (this.elements[root2] < this.elements[root1]) {
            this.elements[root1] = root2;             // root2 is taller; make root2 new root
        } else {
        	if (this.elements[root1] == this.elements[root2]) {
            	this.elements[root1]--;            // Both trees same height; new one is taller
            }
            
        	this.elements[root2] = root1;       // root1 equal or taller; make root1 new root
        }
    }

    /**
     *  find() finds the (int) name of the set containing a given element.
     *  Performs path compression along the way.
     *
     *  @param x the element sought.
     *  @return the set containing x.
     **/
    public int find(int x) {
        if (this.elements[x] < 0) {
            return x;
        } else {
            // Find out who the root is; compress path by making the root x's parent.
        	this.elements[x] = find(this.elements[x]);
        	return elements[x]; // Return the root
        }
    }
}