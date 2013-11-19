package binarySearchTree;

/**
 * Binary Search Tree implementation
 * 
 * @author Rodrigo Alves @ CIn/UFPE
 * http://en.wikipedia.org/wiki/Binary_search_tree
 */

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
	
	public BST deleteMin() {
		BST r = new BST();
		
		if (this.left == null) {
			r = this.right;
			return r;
		} else {
			this.left = this.left.deleteMin();
			return this;
		}
	}
	
	public BST delete(int key) {
		BST r = new BST();
		BST smaller = new BST();
		
		if (this == null) {
			return null;
		} else if (this.value > key) {
			this.left = this.left.delete(key);
			return this;
		} else if (this.value < key) {
			this.right = this.right.delete(key);
			return this;
		} else { // root.value == key a.k.a has two children
			if (this.left != null && this.right != null) {
				smaller = this.left;
				this.right.left = smaller;
				r = this.right;
				return r;
			}
			
			if (this.left == null) {
				r = this.right;
			} else if (this.right == null) {
				r = this.left;
			} else {
				this.right = this.right.deleteMin();
				this.value = key;
			}
			
			return r;
		}
	}
	
	public BST search(int key) {
		if (this == null) {
			return null;
		} else {
			if (key == this.value) {
				return this;
			} else if (key > this.value) {
				return this.right.search(key);
			} else { // key < this.value
				return this.left.search(key);
			}
		}
	}

	public static void preOrder(BST root) {
		if (root != null) {
			System.out.print(root.value + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public static void inOrder(BST root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.value + " ");
			inOrder(root.right);
		}
	}
	
	public static void postOrder(BST root) {
		if (root != null) {
		    postOrder(root.left);
		    postOrder(root.right);
			System.out.print(root.value + " ");
		}
	}
	
	public int getHeight() {
		if (this == null) return -1;
		
		int leftH = this.left.getHeight();
		int rightH = this.right.getHeight();
		
		if (leftH > rightH) return leftH + 1;
		return rightH + 1;
	}
}