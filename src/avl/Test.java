// Testing AVL tree

package avl;

public class Test {
	public static void main(String[] args) {
		Node tree = null;
		
		tree = AVL.insert(50, tree);
		tree = AVL.insert(30, tree);
		tree = AVL.insert(70, tree);
		tree = AVL.insert(60, tree);
		tree = AVL.insert(90, tree);
		tree = AVL.insert(55, tree);
		
		System.out.println("Pre order:");
		AVL.preOrder(tree);
		
		System.out.println();
		
		tree = AVL.remove(tree, 90);
		tree = AVL.recalcularBalance(tree);
		tree = AVL.remove(tree, 70);
		tree = AVL.recalcularBalance(tree);
		
		System.out.println("Pre order:");
		AVL.preOrder(tree);
		System.out.println();
		
		System.out.println("Order:");
		tree = AVL.insert(11, tree);
		
		AVL.inOrder(tree);
		System.out.println();
		
		System.out.println("Post order:");
		AVL.postOrder(tree);
	}
}