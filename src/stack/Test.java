package stack;

public class Test {
	public static void main(String[] args) {
		Stack stack = new Stack();
		
		stack.push(9);
//		stack.push(8);
//		stack.push(1);
//		stack.push(77);
		
		stack.print();
		
		System.out.println("Top is " + stack.top.value + " and top.prev is " + stack.top.value);
		
		System.out.println("Size of the Stack: " + stack.getSize());
		
//		stack.pop();
		stack.print();
		
		System.out.println("Size of the Stack: " + stack.getSize());
	}
}