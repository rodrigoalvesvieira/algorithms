package doublyLinkedList;

public class Test {
	public static void main(String[] args) {
		List list = new List();
		
		list.push(10);
		list.push(50);
		
		list.pushStart(23);
		list.print();

		list.removeEnd();
		list.print();
		
		list.removeBegin();
		list.print();
	}
}