// Testing AVL tree
package avl;

public class Test {
	public static void main(String[] args) {
		AVL tree = new AVL();
		
		AVL.insert(tree, 1, 20, 0, 0, 10);
		AVL.insert(tree, 1, 12, 0, 0, 10);
		AVL.insert(tree, 1, 21, 0, 0, 10);
		
		AVL.inOrder(tree);
		
	}
}
