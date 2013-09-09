// Testing Queue
// http://www.cs.usfca.edu/~galles/visualization/QueueLL.html

package queue;

public class Test {
	public static void main(String[] args) {
		Queue queue = new Queue();
		
		queue.enqueue(10);
		queue.enqueue(30);
		queue.enqueue(42);
		queue.enqueue(10);
		queue.enqueue(77);
		queue.enqueue(666);
		
		queue.print();

		queue.dequeue();
		queue.print();
		
		queue.dequeue();
		queue.print();
		
		// Get top
		System.out.println(queue.getTop());
		// Get last element
		System.out.println(queue.getLastElement());
	}
}