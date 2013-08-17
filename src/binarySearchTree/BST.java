// Binary Search Tree implementation
// Rodrigo Alves @ CIn/UFPE
// http://en.wikipedia.org/wiki/Binary_search_tree

package binarySearchTree;

class BST {
	BST left;
	BST right;
	int value;
	
	public BST() {
		this.left = this.right = null;
		this.value = 0;
	}
	
	public BST(int i) {
		this.left = this.right = null;
		this.value = i;
	}
	
	public BST insert(int i) {
		BST no = new BST(i);
		
		if (this.value == 0) {
			this.value = i;
		} else if (i < this.value) {
			if (this.left == null) {
				this.left = no;
			} else {
				this.left.insert(i);
			}
		} else {
			if (this.right == null) {
				this.right = no;
			} else {
				this.right.insert(i);
			}
		}
		
		return no;
	}

	public BST getLeft() {
		return left;
	}

	public void setLeft(BST left) {
		this.left = left;
	}

	public BST getRight() {
		return right;
	}

	public void setRight(BST right) {
		this.right = right;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void preOrder() {
		if (this != null) {
			System.out.println(value + " ");
			left.preOrder();
			right.preOrder();
		}
	}
	
	public void inOrder() {
		if (this != null) {
			left.inOrder();
			System.out.println(value + " ");
			right.inOrder();
		}
	}
	
	public void postOrder() {
		if (this != null) {
		    left.postOrder();
		    right.postOrder();
			System.out.println(value + " ");
		}
	}
	
	public static String printNode(BST tree) {
		String answer = "";
		StringBuilder sb = new StringBuilder();
		
		if (tree.value == 0) return answer + "\n";
		if (tree.left != null) answer += (printNode(tree.left) + "\n");
		if (tree.right != null) answer += (printNode(tree.right) + "\n");
		
		sb.append(tree.value);
		answer += sb.toString();
		
		return answer;
	}
}