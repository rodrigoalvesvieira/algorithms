package binarySearchTree;

public class Test {
	public static void main(String[] args) {
		BST arvore = new BST();
		
		int[] numbers = {10, 40, 30, 1, 2, 4, 54, 87, 3, 12};
		
		for (int i = 0; i < 10; i++) {
			arvore.insert(numbers[i]);
		}
		
		System.out.println("Pre Order: ");
		BST.preOrder(arvore);
		System.out.println();
	
		System.out.println("Order: ");
		BST.inOrder(arvore);
		System.out.println();
		
		System.out.println("Post Order: ");
		BST.postOrder(arvore);
	}
}