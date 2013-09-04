// AVL Tree (Adelson-Velskii and Landis' tree) implementation
// Rodrigo Alves @ CIn/UFPE
// http://en.wikipedia.org/wiki/AVL_tree

package avl;

public class AVL {
	int noElements = 0;
	int level = 0;
	int value = 0;
	int rotation = 0;
	
	AVL leftChild;
	AVL rightChild;
	
	int identifier;
	int height;
	
	public AVL() {
		this.value = this.height = this.identifier = 0;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	public AVL(int value) {
		this.value = value;
	}
	
	// Removes the minimal from the right and returns the "new" node
	public AVL removeMinRight(AVL rightTree) {
		AVL helper = new AVL();
		
		if (rightTree.leftChild == null) {	
			helper = rightTree.rightChild;
			rightChild = null;
			return helper;
		} else {
			rightTree.leftChild = removeMinRight(rightTree.leftChild);
			return rightTree;
		}
	}
	
	static int getHeight(AVL node) {
		if (node == null) return 0;
	
		int leftHeight = getHeight(node.leftChild);
		int rightHeight = getHeight(node.rightChild);
		return leftHeight > rightHeight ? (leftHeight + 1) : (rightHeight + 1);
	}
	
	static int maximal(int a, int b) {
		return (a > b)? a : b;
	}
	
	static int balancingFactor(AVL root) {
		if (root == null) return 0;
		return getHeight(root.leftChild) - getHeight(root.rightChild);
	}
	
	static // Creates a new node from with a identifier and a value
	// (with both the left and right child null)
	AVL newNode(int i, int v) {
		AVL node = new AVL();
		node.identifier = i;
		node.value = v;
		node.height = 1;	
		return node;
	}
	
	public static void preOrder(AVL root) {
	  	if (root != null) {
	  		System.out.print(root.value + " ");
	  		preOrder(root.leftChild);
	  		preOrder(root.rightChild);
		}
	}
	
	public static void inOrder(AVL root) {
	  	if (root != null) {
	  		inOrder(root.leftChild);
	  		System.out.print(root.value + " ");
	  		inOrder(root.rightChild);
		}
	}
	
	public static void postOrder(AVL root) {
	  	if (root != null) {
	  		postOrder(root.leftChild);
	  		postOrder(root.rightChild);
	  		System.out.print(root.value + " ");
		}
	}
	
	static AVL rotateRight(AVL node) {
		AVL a = node.leftChild;
		AVL b = a.rightChild;
		
		// do the rotation
		a.rightChild = node;
		node.leftChild = b;
		
		// update height
		node.height = maximal(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
		a.height = maximal(getHeight(a.leftChild), getHeight(a.rightChild)) + 1;
		
		// returns the new node
		return a;
	}
	
	static AVL rotateLeft(AVL node) {
		AVL a = node.rightChild;
		AVL b = a.leftChild;
		
		a.leftChild = node;
		node.rightChild = b;
		
		node.height = maximal(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
		a.height = maximal(getHeight(a.leftChild), getHeight(a.rightChild)) + 1;
		
		return a;
	}
	
	// Gets smaller value from the left of a sub-tree
	AVL getSmaller(AVL node) {
		AVL helper = node;
		while (helper.leftChild != null) {
			helper = helper.leftChild;
		}
		
		return helper;
	}
	
	AVL search(AVL tree, int t, int level, int value, int n) {
		level = n;
		AVL helper = tree;
		
		if (tree == null) {
			return null; // Empty tree, so nothing to do here. Move along
		} else {
			if (t > tree.identifier) {
				helper = search(tree.rightChild, t, level, value, n+1);
			} else if (t < tree.identifier) {
				helper = search(tree.leftChild, t, level, value, n+1);
			} else {
				value = helper.value;
			}
			return helper;
		}
	}
	
	static AVL insert(AVL node, int i, int value, int level, int rotation, int n) {
		level = n; // if null, it's the head
		if (node == null) return newNode(i, value);
		
		if (i < node.identifier) {
			node.leftChild = insert(node.leftChild, i, value, level, rotation, n+1);
		} else {
			node.rightChild = insert(node.rightChild, i, value, level, rotation, n+1);
		}
		
		// update height
		node.height = maximal(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
		
		// check if balanced
		int balance = balancingFactor(node);
		
		// If not balanced, there are 4 possibilities
		// Heavy to the left, right rotation
		if (balance > 1 && i < node.leftChild.identifier) {
			level -= 1;
			rotation = 1;
			return rotateRight(node);
		}
		
		// Heavy to the right, left rotation
		if (balance < -1 && i > node.rightChild.identifier) {
			rotation = 2;
			level -= 1;
			return rotateLeft(node);
		}
		
		// Double rotation to the right
		if (balance > 1 && i > node.leftChild.identifier) {
			rotation = 3;
			level -= 2;
			node.leftChild = rotateLeft(node.leftChild);
			return rotateRight(node);
		}
		
		// Double rotation to the left
		if (balance < -1 && i < node.rightChild.identifier) {
			rotation = 4;
			level -= 2;
			node.rightChild = rotateRight(node.rightChild);
			return rotateLeft(node);
		}
		
		// Returns updated tree
		return node;
	}
	
	AVL remove(AVL root, int identifier) {
		if (root == null) return root; // nothing to do
		
		// Smaller value, get sub-tree to the left
		if (identifier < root.identifier) {
			root.leftChild = remove(root.leftChild, identifier);
		} else if (identifier > root.identifier) { // greater value, get sub-tree to the right
			root.rightChild = remove(root.rightChild, identifier);
			
		} else { // found it!
			// when it is got <= 1 sub-trees
			if ((root.leftChild == null) || root.rightChild == null) {
				AVL helper = (root.leftChild != null) ? root.leftChild : root.rightChild;
			
				// leaf nodes
				if (helper == null) {
					helper = root;
					root = null;
				} else { // node with 1 sub-tree
					root = helper;
				}
			} else {
				// Node with 2 sub-trees
				AVL helper = getSmaller(root.rightChild);
				// Copy information from the successors
				
				root.identifier = helper.identifier;
				root.value = helper.value;
				
				// Deletes successor
				root.rightChild = remove(root.rightChild, helper.identifier);
			}
		}
		
		// If node is null
		if (root == null) return root;
		
		// Update height in node
		root.height = maximal(getHeight(root.leftChild), getHeight(root.rightChild)) + 1;
		
		// Checks if the node is un-balanced
		int balance = balancingFactor(root);
		
		// If loses balance, there are 4 possibilities
		// Weights to the left, right rotation
		if (balance > 1 && balancingFactor(root.leftChild) >= 0) return rotateRight(root);
		
		// Double rotation to the right
		if (balance > 1 && balancingFactor(root.leftChild) < 0) {
			root.leftChild = rotateLeft(root.leftChild);
			return rotateRight(root);
		}
		
		// Weights to the right, left rotation
		if (balance < -1 && balancingFactor(root.rightChild) <= 0) return rotateLeft(root);
	
		// Double rotation to the left
		if (balance < -1 && balancingFactor(root.rightChild) > 0) {
			root.rightChild = rotateRight(root.rightChild);
			return rotateLeft(root);
		}

		return root;
	}
}
