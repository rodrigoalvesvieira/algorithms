/**
 * AVL Tree (Adelson-Velskii and Landis' tree) implementation
 * 
 * A balanced binary tree developed to preserve the logarithmic property through the
 * rotation of its nodes
 * 
 * Rodrigo Alves @ CIn/UFPE
 * http://en.wikipedia.org/wiki/AVL_tree
 */
package avl;

class Node {
	int key;
	int balance;
	Node leftChild;
	Node rightChild;
	
	public Node(int value){
		this.key = value;
		this.balance = 0;
		this.leftChild = null;
		this.rightChild = null;
	}
}

public class AVL {	
	public static int abs(int x){
		if (x < 0) {
			return -x;
		} else {
			return x;
		}
	}
	
	public static int max(int a, int b){
		if (a < b){
			return b;
		} else {
			return a;
		}
	}
	
	public static int getHeight(Node root){
		if (root == null) {
			return -1;
		} else {
			return 1 + max(getHeight(root.leftChild), getHeight(root.rightChild));
		}
	}
	
	public static Node search(Node root, int value) {
		if (root == null) return null;
		
		if (root.key == value) {
			return root;
		} else if (root.key < value) {
			return search(root.rightChild, value);
		} else if (root.key > value) {
			return search(root.leftChild, value);
		}
		
		return null;
	}
	
	public static Node simpleRightRotation(Node root){
		Node A  = root;
		Node B = root.leftChild;
		Node C = B.rightChild;;
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
	
	public static Node doubleRightRotation(Node root){
		Node A = root;
		Node B = root.leftChild;
		Node C = root.leftChild.rightChild;
		Node D = root.leftChild.rightChild.leftChild;
		Node E = root.leftChild.rightChild.rightChild;
		
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
	
	public static Node simpleLeftRotation(Node tree){
		Node A  = tree;
		Node B = tree.rightChild;
		Node C = B.leftChild;
		
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
	
	public static Node doubleLeftRotation(Node root){
		Node A = root;
		Node B = A.rightChild;
		Node C = B.leftChild;
		Node D = C.rightChild;
		Node E = C.leftChild;
		
		A.rightChild = E;
		B.leftChild = D;
		C.rightChild= B;
		C.leftChild = A;
		
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
	
	public static Node insert(int value, Node root) {
		if (root == null) {
			root = new Node(value);
		} else {
			if (value < root.key) {
				root.leftChild = insert(value, root.leftChild);
				
				int helper1, helper2;
				
				helper1 = 1 + getHeight(root.rightChild);
				helper2 =  1 + getHeight(root.leftChild);
				root.balance =  helper1 - helper2;
				
				// System.out.println(root.num + " => " + root.balance + " " + value);
				if (root.balance == -2) {
					if (root.leftChild.balance == -1) {
						root = simpleRightRotation(root);
					} else {
						root = doubleRightRotation(root);
					}
				}
			} else if (value > root.key) {
				root.rightChild = insert(value, root.rightChild);
				int helper1, helper2;
				
				helper1 = 1 + getHeight(root.rightChild);
				helper2 =  1 + getHeight(root.leftChild);
				root.balance =  helper1 - helper2;
				
				// Print the element to be inserted and its balancing factor
				// System.out.println(arvore.num + " => " + arvore.balance + " " + valor);
				
				if (root.balance == 2 ){
					if (root.rightChild.balance == 1 ){
						root = simpleLeftRotation(root);
					} else {
						root = doubleLeftRotation(root);
					}
				}
			}
		}
		return root;
	}
	
	public static Node remove(Node root, int value) {
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
						Node previous = root;
						Node next = root.rightChild;
						
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
	
	public static Node recalcularBalance(Node root){
		if (root != null) {
			root.leftChild = recalcularBalance(root.leftChild);
			root.rightChild = recalcularBalance(root.rightChild);
			
			int helper1, helper2;
			
			helper1 = 1 + getHeight(root.rightChild);
			helper2 =  1 + getHeight(root.leftChild);
			root.balance =  helper1 - helper2;
			
			if (root.balance == 2) {
				if (root.rightChild.balance == 1) {
					root = simpleLeftRotation(root);
				}else {
					root = doubleLeftRotation(root);
				}
			} else if (root.balance == -2) {
				if (root.leftChild.balance == -1) {
					root = simpleRightRotation(root);
				} else {
					root = doubleRightRotation(root);
				}	
			}
		}
		return root;
	}
	
	/**
	 * Walks the tree in the (root-left-right) fashion
	 * @param root
	 */
	public static void preOrder(Node root) {
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
	public static void inOrder(Node root) {
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
	public static void postOrder(Node root) {
		if (root != null) {
			postOrder(root.leftChild);
			postOrder(root.rightChild);
			System.out.print("(" + root.key +" , "+ root.balance + ") " );
		}
	}
}