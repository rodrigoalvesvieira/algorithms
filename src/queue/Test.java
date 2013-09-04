// Testing Queue

package queue;

public class Test {
	public static void main(String[] args) {
		Queue queue = new Queue();
		
		queue.enqueue(10);
		queue.enqueue(30);
		queue.enqueue(42);
		
//		System.out.println(queue.top.value);
//		System.out.println(queue.getLastElement());
		
		queue.dequeue();
		queue.dequeue();
		
		queue.print();
	}
}