package doublyLinkedList;

public class Test {
	public static void main(String[] args) {
		System.out.println("Testing Doubly Linked List\n");

		List list = new List();
		
		System.out.println("List size is " + list.size);
		System.out.println("Adding two nodes sequentially");
		list.push(10);
		list.push(50);
		list.print();
		System.out.println("List size is " + list.size);
		System.out.println();
		
		System.out.println("Adding 23 to the beginning");
		list.pushStart(23);
		list.print();
		System.out.println("List size is " + list.size);
		System.out.println();

		System.out.println("Removing leading element");
		list.removeEnd();
		list.print();
		System.out.println("List size is " + list.size);
		System.out.println();
		
		System.out.println("Adding four nodes sequentially");
		list.push(77);
		list.push(666);
		list.push(42);
		list.push(7);
		list.print();
		System.out.println("List size is " + list.size);
		System.out.println();

		System.out.println("Removing trailing element");
		list.removeBegin();
		list.print();
		System.out.println("List size is " + list.size);
		System.out.println();
		
		System.out.println("Adding to begin");
		list.pushStart(100);
		list.print();
		System.out.println("List size is " + list.size);
		System.out.println();
	}
}