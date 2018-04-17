package cc222ip_assign2;

/**
 * @author Chris_Chevalier
 *
 */
public class Word implements Comparable<Word> {
	private String word;

	/**
	 * @param str
	 */
	public Word(String str) throws NullPointerException { // Word constructor.
		if(str == null)
			throw new NullPointerException("The string gave in parameter is null."); // Handle exception.
		word = str; // A word is composed by a string.
	}
	
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Word w = new Word("Abee"); // Creation of two new words.
			Word o = new Word("abee");
			if(w.equals(o)) // Test the 'equals' method.
				System.out.println(w + " and " + o + " are the same word.");
			else
				System.out.println(w + " and " + o + " aren't the same word...");
			
			System.out.println("\nLet's see their hash codes:\n");
			System.out.println(w.hashCode()); // Test the 'hashCode' method.
			System.out.println(o.hashCode());
			System.out.println("\nNow, let's take a look at the integer returns by the comparison of the both words: " + w.compareTo(o) + "."); // Test the 'CompareTo' method.
		} catch(Exception e) { e.getMessage(); } // Handle exceptions.
	}
	
	public String toString() { return word; } // Allows to have a clear display of a word.
	
	/* Override Object methods */
	public int hashCode() { // Compute a hash value for word.
		int hc = 0; // Stock the hash code value.
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			hc += Character.getNumericValue(c); // Add numeric values of all the word's characters to return his hash code.
		}
		return hc;
	}
	
	public boolean equals(Object other) throws NullPointerException { // True if two words are equal.
		if(other == null)
			throw new NullPointerException("The object gave in parameter is null."); // Handle exception.
		if(other.getClass() == this.getClass()) // Check if the other object is a word.
			return word.toUpperCase().equals(other.toString().toUpperCase());
		return false;
	}
	
	/* Implement Comparable */
	public int compareTo(Word w) throws NullPointerException { // Compares two words lexicographically.
		if(w == null)
			throw new NullPointerException("The word gave in parameter is null."); // Handle exception.
		return word.compareToIgnoreCase(w.toString());
	}
}