package hashTable;

/**
 * Testing Hash Table
 * @author Rodrigo Alves @ CIn/UFPE
 *
 */
public class Test {
	public static void main(String[] args) {
		System.out.println("Testing Hash Table\n");
		
		HashTable hash = new HashTable(100);
		
		int[] lines = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] columns = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		for (int i = 0; i < lines.length; i++) {
			for (int j = 0; j < columns.length; j++) {
				hash.put(lines[i++], columns[j]);
			}
		}
		
		hash.put(1, 1000);
		
		System.out.println(hash.get(0));
		System.out.println(hash.get(1));
		
		System.out.println("Filled size is " + hash.filledSize);
		
		hash.put(31, 1001);
		hash.put(22, 1001);

		System.out.println(hash.get(1));
		
		System.out.println(hash.get(5));
		
		System.out.println("Filled size is " + hash.filledSize);
		
		hash.print();

		System.out.println("Removing element 5:");

		hash.remove(5);
		System.out.println("Filled size is " + hash.filledSize);
		hash.print();
	}
}