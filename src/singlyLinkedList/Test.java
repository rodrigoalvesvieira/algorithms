package singlyLinkedList;

public class Test {
	public static void main(String[] args) {
		List list = new List();
		
		list.push(10); // 10
		list.push(50); // 10, 50
		list.push(90); // 10, 50, 90
		
		Node n = list.search(list.first, 10); // will find
		
		if (n == null) {
			System.out.println("No 12 nao existe!");
		} else {
			System.out.println(n.value * n.value); // 100
			list.pushAfter(n, 77); // inserting a new node 77 right after 10. Will be 10, 77, 50, 90
		}

		System.out.println("List size: " + list.getSize()); // Gonna be 4
		list.pop(); // remove 90

		list.print(); // 10, 77, 50
		System.out.println("List size: " + list.getSize());
	}
}