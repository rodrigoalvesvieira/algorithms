package binarySearchTree;

public class Test {
	public static void main(String[] args) {
		System.out.println("Testing Binary Search Tree\n");

		BST tree = new BST();
		int[] numbers = {10, 40, 30, 1, 2, 4, 54, 87, 3, 12};
		
		for (int i = 0; i < 10; i++) {
			tree.insert(numbers[i]);
		}
		
		System.out.println("Pre Order: ");
		BST.preOrder(tree);
		System.out.println();
	
		System.out.println("Order: ");
		BST.inOrder(tree);
		System.out.println();
		
		System.out.println("Post Order: ");
		BST.postOrder(tree);
		System.out.println();
		
		// Deleting minimum node
		tree.deleteMin();
		System.out.println("Order: ");
		BST.inOrder(tree);
		System.out.println();
		
		// Searching for existing node
		BST res = tree.search(12);
		System.out.println(res.value);
		System.out.println();

		// Deleting arbitrary node
		tree.delete(12);
		BST.inOrder(tree);
		System.out.println();
	}
}