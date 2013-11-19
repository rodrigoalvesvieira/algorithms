/**
 * Testing AVL tree
 * Animation available at http://www.qmatica.com/DataStructures/Trees/AVL/AVLTree.html
 * To better see it in action. Click Options and enable "factors"
 */

package avl;

public class Test {
	public static void main(String[] args) {
		System.out.println("Testing AVL tree\n");
		
		AVL tree = null;
		
		tree = AVL.insert(50, tree);
		tree = AVL.insert(30, tree);
		tree = AVL.insert(70, tree);
		tree = AVL.insert(60, tree);
		tree = AVL.insert(90, tree);
		tree = AVL.insert(55, tree);
		tree = AVL.insert(19, tree);
		
		System.out.println("Pre order:");
		AVL.postOrder(tree);
		System.out.println();
		
		tree = AVL.remove(tree, 90);
		tree = AVL.calculateBalance(tree);
		tree = AVL.remove(tree, 70);
		tree = AVL.calculateBalance(tree);
		
		System.out.println("Pre order:");
		AVL.preOrder(tree);
		System.out.println();
		
		System.out.println("Order:");
		tree = AVL.insert(11, tree);
		
		AVL.inOrder(tree);
		System.out.println();
		
		System.out.println("Post order:");
		AVL.postOrder(tree);
		System.out.println();
		
		// Searching for a node in the tree which has the value 30 as key
		AVL a = AVL.search(tree, 30);
		System.out.println("Node key => " + a.key + ", balance => " + a.balance);
	}
}