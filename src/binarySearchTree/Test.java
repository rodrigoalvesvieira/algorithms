package binarySearchTree;

public class Test {
	public static void main(String[] args) {
		BST arvore = new BST();
		
		int[] numbers = {10, 40, 30, 1, 2, 4, 54, 87, 3, 12};
		for(int i = 0; i < 10; i++) {
			arvore.insert(numbers[i]);
		}

		arvore.preOrder();
	}
}