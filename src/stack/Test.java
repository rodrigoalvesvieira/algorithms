package stack;

public class Test {
	public static void main(String[] args) {
		System.out.println("Testing Stack (LIFO) \n");

		Stack stack = new Stack();
		
		System.out.println("Inserting 10 elements sequentially");
		int values[] = {9, 8, 1, 77, 666, 31, 19, 44, 47, 14};
		
		for (int i = 0; i < values.length; i++) stack.push(values[i]);
		
		stack.print();
		System.out.println("Top value is " + stack.top.value + " and size is " + stack.size);	
		System.out.println("top previous is " + stack.top.previous.value);

		System.out.println();
		System.out.println("Running pop()");
		int j = stack.pop();
		System.out.println("popped value was " + j + ". Stack is now size " + stack.size + " and");
		stack.print();
		
		System.out.println();
		System.out.println("Running pop() again");
		int k = stack.pop();
		System.out.println("popped value was " + k + ". Stack is now size " + stack.size + " and");
		stack.print();
		
		System.out.println();
		System.out.println("Now searching for a Node with key 666");
		
		Node result = stack.search(stack.begin, 666);
		System.out.println("Node found! Value is " + result.value);
	}
}