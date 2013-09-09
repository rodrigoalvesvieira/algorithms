/**
 * Testing Dynamic Array data structure
 */
package dynamicArray;

public class Test {
	public static void main(String[] args) {
		System.out.println("Testing Dynamic Array\n");
		
		DynamicArray da = new DynamicArray(10);
		for (int i = 0; i < 100; i++) {
			da.push(i*i);
		}
		
		da.print();
		System.out.println(da.index);
	}
}