package hashTable;

class Node {
	int key;
	int value;

    Node(int key, int value) {
    	this.key = key;
    	this.value = value;
    }
    
    public String toString() {
    	return "{" + this.key + " => " + this.value + "}";
    }
}

/**
 * Hash Table (dictionary) implementation
 * http://en.wikipedia.org/wiki/Hash_table
 * 
 * @author Rodrigo Alves @ CIn/UFPE
 *
 */
public class HashTable {
    int tableSize;  // Capacity of Hash Table
    int filledSize; // Indicates the number of elements set in the Hash Table 

    Node[] table;

    HashTable(int tableSize) {
    	this.tableSize = tableSize;
    	this.table = new Node[tableSize];
    	this.filledSize = 0;
    	for (int i = 0; i < tableSize; i++) this.table[i] = null;
    }

    public int get(int key) {
    	int hash = (key % this.tableSize);
    	
    	while (this.table[hash] != null && this.table[hash].key != key) {
    		hash = (hash + 1) % this.tableSize;
    	}
    	
    	if (this.table[hash] == null) {
    		return -1;
    	} else {
    		return this.table[hash].value;
    	}
    }
    
    public void remove(int key) {
    	this.table[key] = null;
    	this.filledSize--;
    }

    public void put(int key, int value) {
    	int hash = (key % this.tableSize);
    	
    	while (this.table[hash] != null && this.table[hash].key != key) {
    		hash = (hash + 1) % this.tableSize;
    	}
    	
    	if (this.table[hash] == null || this.table[hash].key != key) this.filledSize++;
    	this.table[hash] = new Node(key, value);
    }
    
    public void print() {
    	for (int i = 0; i < this.filledSize; i++) {
    		if (this.table[i] != null) System.out.print(table[i]);
    	}
    	System.out.println();
    }
}