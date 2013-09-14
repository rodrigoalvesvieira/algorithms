// Testing Queue
// http://www.cs.usfca.edu/~galles/visualization/QueueLL.html

package queue;

public class Test {
	public static void main(String[] args) {
		System.out.println("Testing Queue\n");
		
		Queue queue = new Queue();
		
		queue.enqueue(10);
		queue.enqueue(30);
		queue.enqueue(42);
		queue.enqueue(10);
		queue.enqueue(77);
		queue.enqueue(666);
		
		Node a = queue.search(77);
		System.out.println("Valor: " + a.value + " prev: " + a.previous.value + " next: " + a.next.value);
		
		queue.print();
		System.out.println("Back: " + queue.getBack());
		System.out.println("Front: " + queue.getFront());

		System.out.println();
		System.out.println("Realizando dequeue");
		int p = queue.dequeue();
		System.out.println("Removido " + p + ". Front agora é: " + queue.getFront());
		queue.print();
		System.out.println();

		System.out.println("Realizando dequeue");
		int q = queue.dequeue();
		System.out.println("Removido " + q + ". Front agora é: " + queue.getFront());
		queue.print();
		System.out.println();

//		queue.print();
		
//		queue.dequeue();
//		queue.print();
		
		// Get top
//		System.out.println(queue.getBack());
		// Get last element
//		System.out.println(queue.getLastElement());
	}
}