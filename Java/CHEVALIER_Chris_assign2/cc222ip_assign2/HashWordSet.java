package cc222ip_assign2;

import java.util.Iterator;

/**
 * @author Chris_Chevalier
 *
 */
public class HashWordSet implements WordSet {
	public static int sz; // Current size.
	public Nod[] buckets;
	
	public HashWordSet() {
		buckets = new Nod[128]; // Initial bucket size.
		sz = 0;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 HashWordSet hws = new HashWordSet(); // Create a Hash Word Set to test the different methods on it.
		 Word w = new Word("ABC");
		 hws.add(new Word("Chris")); // We add some words in the structure.
		 hws.add(new Word("CHRIS"));
		 hws.add(w);
		 hws.add(new Word("gyuk"));
	
		 Iterator <Word> ite = hws.iterator(); // Show the content of the HashWordSet with iterator.
		 while(ite.hasNext())
			 System.out.println(ite.next());
		 
		 System.out.println("\nSize: " + hws.size()); // Test 'size' and 'contains' methods.
		 if(hws.contains(w))
			 System.out.println("The word " + w + " is in the Hash Word Set.");
		else
			System.out.println("The word " + w + " is not in the Hash Word Set.");
	}

	@Override
	public void add(Word word) throws NullPointerException {
		if(word == null)
			throw new NullPointerException("The word gave in parameter is null."); // Handle exception.
		int pos = getBucketNumber(word);
		Nod node = buckets[pos]; // First node in list
		while(node != null) { // Search list
			if(node.value.equals(word))
				return; // Element found!
			else
				node = node.next; // Next node in list
		}
		node = new Nod(word); // Not found, add new node as first entry
		node.next = buckets[pos];
		buckets[pos] = node;
		sz++; // Increase current size.
		if(sz == buckets.length) rehash(); // Rehash if needed.
	}
	
	public int getBucketNumber(Word word) throws NullPointerException {
		if(word == null)
			throw new NullPointerException("The word gave in parameter is null."); // Handle exception.
		int hc = word.hashCode(); // Reuse hashCode in Word class.
		if(hc < 0) hc = -hc; // Make sure non-negative.
		return hc % buckets.length; // Simple hash function.
	}
	
	private void rehash() {
		Nod[] tmp = buckets; // Reference to old buckets.
		buckets = new Nod[2 * tmp.length]; // New empty buckets.
		sz = 0;
		for(Nod n : tmp) { // Insert old values into new buckets.
			if(n == null) continue; // Empty bucket;
			while(n != null) {
				add(n.value); // Add elements again.
				n = n.next;
			}
		}
	}

	@Override
	public boolean contains(Word word) throws NullPointerException {
		if(word == null)
			throw new NullPointerException("The word gave in parameter is null."); // Handle exception.
		int pos = getBucketNumber(word); // Stock index where the word in parameter is situated.
		Nod node = buckets[pos];
		while(node != null) {
			if(node.value.equals(word))
				return true; // Found!
			node = node.next;
		}
		return false; // Not found.
	}

	@Override
	public int size() {
		return sz;
	}

	@Override
	public Iterator<Word> iterator() {
		return new Iterator<Word>() {
			int pos = 0;
			int c = 0;

			@Override
			public boolean hasNext() {
				return c < sz;
			}

			@Override
			public Word next() {
				while(buckets[pos] == null)
					pos++;
				c++;
				return buckets[pos++].value;
			}
		};
	}
}
