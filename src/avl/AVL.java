/**
 * AVL Tree (Adelson-Velskii and Landis' tree) implementation
 *
 * A balanced binary tree developed to preserve the logarithmic property through the
 * rotation of its nodes
 *
 * Height of the tree is always guaranteed to be H or H-1
 *
 * Rodrigo Alves @ CIn/UFPE
 * http://en.wikipedia.org/wiki/AVL_tree
 */

package avl;

public class AVL {
	int key;
	int balance;
	AVL leftChild;
	AVL rightChild;

	public AVL(int value) {
		this.key = value;
		this.balance = 0;
		this.leftChild = null;
		this.rightChild = null;
	}

	public static int abs(int x) {
		if (x < 0) return -x;
		return x;
	}

	public static int max(int a, int b) {
		if (a < b) return b;
		return a;
	}

	public static int getHeight(AVL root) {
		if (root == null) return -1;
		return 1 + max(getHeight(root.leftChild), getHeight(root.rightChild));
	}

	public static AVL search(AVL root, int value) {
		if (root == null) return null;

		if (root.key == value) return root;
		else if (root.key < value) return search(root.rightChild, value);
		else if (root.key > value) return search(root.leftChild, value);

		return null;
	}

	public static AVL simpleRightRotation(AVL root) {
		AVL A  = root;
		AVL B = root.leftChild;
		AVL C = B.rightChild;;
		B.rightChild = A;
		A.leftChild = C;

		int helper1, helper2;
		helper1 = 1 + getHeight(A.rightChild);
		helper2 =  1 + getHeight(A.leftChild);
		A.balance =  helper1 - helper2;

		helper1 = 1 + getHeight(B.rightChild);
		helper2 =  1 + getHeight(B.leftChild);
		B.balance =  helper1 - helper2;
		root = B;

		return root;
	}

	public static AVL doubleRightRotation(AVL root) {
		AVL A = root;
		AVL B = root.leftChild;
		AVL C = root.leftChild.rightChild;
		AVL D = root.leftChild.rightChild.leftChild;
		AVL E = root.leftChild.rightChild.rightChild;

		A.leftChild = E;
		B.rightChild = D;
		C.leftChild = B;
		C.rightChild = A;

		int helper1, helper2;

		helper1 = 1 + getHeight(A.rightChild);
		helper2 =  1 + getHeight(A.leftChild);
		A.balance =  helper1 - helper2;

		helper1 = 1 + getHeight(B.rightChild);
		helper2 = 1 + getHeight(B.leftChild);
		B.balance =  helper1 - helper2;

		helper1 = 1 + getHeight(C.rightChild);
		helper2 = 1 + getHeight(C.leftChild);
		C.balance =  helper1 - helper2;

		root = C;
		return root;
	}

	public static AVL simpleLeftRotation(AVL tree) {
		AVL A  = tree;
		AVL B = tree.rightChild;
		AVL C = B.leftChild;

		B.leftChild = A;
		A.rightChild = C;

		int helper1, helper2;

		helper1 = 1 + getHeight(A.rightChild);
		helper2 =  1 + getHeight(A.leftChild);
		A.balance = helper1 - helper2;

		helper1 = 1 + getHeight(B.rightChild);
		helper2 =  1 + getHeight(B.leftChild);
		B.balance = helper1 - helper2;

		tree = B;
		return tree;
	}

	public static AVL doubleLeftRotation(AVL root) {
		AVL A = root;
		AVL B = A.rightChild;
		AVL C = B.leftChild;
		AVL D = C.rightChild;
		AVL E = C.leftChild;

		A.rightChild = E;
		B.leftChild  = D;
		C.rightChild = B;
		C.leftChild  = A;

		int helper1, helper2;

		helper1 = 1 + getHeight(A.rightChild);
		helper2 =  1 + getHeight(A.leftChild);
		A.balance =  helper1 - helper2;

		helper1 = 1 + getHeight(B.rightChild);
		helper2 = 1 + getHeight(B.leftChild);
		B.balance =  helper1 - helper2;

		helper1 = 1 + getHeight(C.rightChild);
		helper2 = 1 + getHeight(C.leftChild);
		C.balance =  helper1 - helper2;

		root = C;
		return root;
	}

	public static AVL insert(int value, AVL root) {
		if (root == null) {
			root = new AVL(value);
		} else {
			if (value < root.key) {
				root.leftChild = insert(value, root.leftChild);

				int helper1, helper2;

				helper1 = 1 + getHeight(root.rightChild);
				helper2 =  1 + getHeight(root.leftChild);
				root.balance =  helper1 - helper2;

				if (root.balance == -2) {
					if (root.leftChild.balance == -1) root = simpleRightRotation(root);
					else root = doubleRightRotation(root);
				}
			} else if (value > root.key) {
				root.rightChild = insert(value, root.rightChild);
				int helper1, helper2;

				helper1 = 1 + getHeight(root.rightChild);
				helper2 =  1 + getHeight(root.leftChild);
				root.balance =  helper1 - helper2;

				if (root.balance == 2 ) {
					if (root.rightChild.balance == 1 ) root = simpleLeftRotation(root);
					else root = doubleLeftRotation(root);
				}
			}
		}
		
		return root;
	}

	public static AVL remove(AVL root, int value) {
		if (root == null) {
			System.out.println("No element found!");
		} else {
			if (root.key == value) {
				if (root.rightChild == null && root.leftChild == null ) {
					root = null;
				} else if (root.leftChild != null && root.rightChild == null) {
					root = root.leftChild;
				} else if (root.leftChild == null && root.rightChild != null) {
					root = root.rightChild;
				} else {
					// Removing using the next node
					if (root.rightChild.leftChild == null) {
						root.rightChild.leftChild = root.leftChild;
						root = root.rightChild;
					} else {
						AVL previous = root;
						AVL next = root.rightChild;

						while (next.leftChild != null) {
							previous = next;
							next = next.leftChild;
						}

						previous.leftChild = next.rightChild;
						next.leftChild = root.leftChild;
						next.rightChild = root.rightChild;
						root = next;
					}
				}
			} else if (root.key < value) {
				root.rightChild = remove(root.rightChild, value);
			} else if (root.key > value) {
				root.leftChild = remove(root.leftChild, value);
			}
		}

		return root;
	}

	public static AVL calculateBalance(AVL root) {
		if (root != null) {
			root.leftChild = calculateBalance(root.leftChild);
			root.rightChild = calculateBalance(root.rightChild);

			int helper1, helper2;

			helper1 = 1 + getHeight(root.rightChild);
			helper2 =  1 + getHeight(root.leftChild);
			root.balance =  helper1 - helper2;

			if (root.balance == 2) {
				if (root.rightChild.balance == 1) root = simpleLeftRotation(root);
				else root = doubleLeftRotation(root);
			} else if (root.balance == -2) {
				if (root.leftChild.balance == -1) root = simpleRightRotation(root);
				else root = doubleRightRotation(root);
			}
		}
		
		return root;
	}

	/**
	 * Walks the tree in the (root-left-right) fashion
	 * @param root
	 */
	public static void preOrder(AVL root) {
		if (root != null) {
			System.out.print("(" + root.key +" , "+ root.balance + ") " );
			preOrder(root.leftChild);
			preOrder(root.rightChild);
		}
	}

	/**
	 * Walks the tree in the (left-root-right) fashion
	 * @param root
	 */
	public static void inOrder(AVL root) {
		if (root != null) {
			inOrder(root.leftChild);
			System.out.print("(" + root.key +" , "+ root.balance + ") " );
			inOrder(root.rightChild);
		}
	}

	/**
	 * Walks the tree in (left-right-root) fashion
	 * @param root
	 */
	public static void postOrder(AVL root) {
		if (root != null) {
			postOrder(root.leftChild);
			postOrder(root.rightChild);
			System.out.print("(" + root.key + " , " + root.balance + ") " );
		}
	}
}