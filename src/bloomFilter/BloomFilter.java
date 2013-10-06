package bloomFilter;

import java.util.BitSet;

/**
 * Bloom Filter implementation
 * "Set" data structure
 * http://en.wikipedia.org/wiki/Bloom_filter
 * 
 * A space-efficient probabilistic data structure
 * 
 * Goal: fast inserts and lookups
 * More space efficient than Hash Tables
 * Allows no deletions
 * False positive probability
 * 
 * We can be sure that something *IS NOT* in the set
 * 
 * Study material:
 * 
 * http://www.javamex.com/tutorials/collections/bloom_filter_java.shtml
 * http://www.javamex.com/tutorials/collections/bloom_filter_false_positives.shtml
 * http://www.javamex.com/tutorials/collections/bloom_filter_false_positives_graph.shtml
 * 
 * @author Rodrigo Alves @ CIn/UFPE
 *
 */
public class BloomFilter {
	private static final int MAX_HASHES = 8;
	private static final long[] byteTable;
	private static final long HSTART = 0xBB40E64DA205B064L;
	private static final long HMULT = 7664345821815920749L;
	
	private final BitSet data;
	private final int noHashes;
	private final int hashMask;
	
	public void add(String s) {
		for (int n = 0; n < noHashes; n++) {
			long hc = hashCode(s, n);
			int bitNo = (int) (hc) & this.hashMask;
			data.set(bitNo);
		}
	}
	
	public boolean contains(String s) {
		for (int n = 0; n < noHashes; n++) {
			long hc = hashCode(s, n);
			int bitNo = (int) (hc) & this.hashMask;
			if (!data.get(bitNo)) return false;
	    }
	    return true;
	}
	
	static {
		byteTable = new long[256 * MAX_HASHES];
		long h = 0x544B2FBACAAF1684L;
	    for (int i = 0; i < byteTable.length; i++) {
	      for (int j = 0; j < 31; j++)
	        h = (h >>> 7) ^ h; h = (h << 11) ^ h; h = (h >>> 10) ^ h;
	      byteTable[i] = h;
	    }
	  }

	  private long hashCode(String s, int hcNo) {
	    long h = HSTART;
	    final long hmult = HMULT;
	    final long[] ht = byteTable;
	    int startIx = 256 * hcNo;
	    for (int len = s.length(), i = 0; i < len; i++) {
	      char ch = s.charAt(i);
	      h = (h * hmult) ^ ht[startIx + (ch & 0xff)];
	      h = (h * hmult) ^ ht[startIx + ((ch >>> 8) & 0xff)];
	    }
	    return h;
	  }


	  public BloomFilter(int log2noBits, int noHashes) {
	    if (log2noBits < 1 || log2noBits > 31)
	      throw new IllegalArgumentException("Invalid number of bits");
	    if (noHashes < 1 || noHashes > MAX_HASHES)
	      throw new IllegalArgumentException("Invalid number of hashes");

	    this.data = new BitSet(1 << log2noBits);
	    this.noHashes = noHashes;
	    this.hashMask = (1 << log2noBits) - 1;
	  }
	  
	  public BloomFilter(int noItems, int bitsPerItem, int noHashes) {
		    int bitsRequired = noItems * bitsPerItem;
		    if (bitsRequired >= Integer.MAX_VALUE) {
		      throw new IllegalArgumentException("Bloom filter would be too big");
		    }
		    int logBits = 4;
		    while ((1 << logBits) < bitsRequired)
		      logBits++;
		    if (noHashes < 1 || noHashes > MAX_HASHES)
		      throw new IllegalArgumentException("Invalid number of hashes");
		    this.data = new BitSet(1 << logBits);
		    this.noHashes = noHashes;
		    this.hashMask = (1 << logBits) - 1;
		  }
}