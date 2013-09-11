package treeSum;

public class Test {

	public static void main(String[] args) {
		System.out.println("Testing 3 sum problem solution\n");
		
		int a[] = {-1, 0, 1};  // yes
		int b[] = {-1, 2, -1}; // yes
		int c[] = {4, 5, -7};  // no
		
		System.out.println(TreeSum.count(a));
		System.out.println(TreeSum.count(b));
		System.out.println(TreeSum.count(c));
	}
}