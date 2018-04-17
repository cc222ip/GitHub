package cc222ip_assign2;

import java.util.Iterator;

/**
 * @author Chris_Chevalier
 *
 */
class TreeWordSet implements WordSet {
	private Word word;
	private TreeWordSet left = null;
	private TreeWordSet right = null;

	TreeWordSet(Word word) {
		this.word = word;
	}
	
	public static void main(String arg[]) {
		TreeWordSet t = new TreeWordSet(new Word("Manon")); // Create a new Tree Word Set with a word as root.
		t.add(new Word("Zoo")); // Add few elements in the tree.
		t.add(new Word("Zoo"));
		t.add(new Word("Chris"));
		t.add(new Word("CHRIs"));
		t.add(new Word("izhdk"));
		t.add(new Word("Ikzn"));
		t.add(new Word("GYUJKJK"));
		
		t.print(); // Test 'print' and 'size' methods.
		System.out.println("\n\nThere is " + t.size() + " elements in the tree.");
		
		Iterator<Word> ite = t.iterator(); // Test iterator to show elements in the tree.
		while(ite.hasNext())
			System.out.println(ite.next());
		
		Word z = new Word("Zoo");
		if(t.contains(z)) // Test 'contains' method.
			System.out.println("The word '" + z + "' is in the tree.");
		else
			System.out.println("The word '" + z + "' is NOT in the tree.");
	}
	
	@Override
	public void add(Word w) throws NullPointerException { // Recursive add.
		if(word == null)
			throw new NullPointerException("The word gave in parameter is null."); // Handle exception.
		if(word.equals(w)) return;
		else if(word.compareTo(w) > 0) { // Check the word in the current branch and compare it with the word to insert it.
			if(left == null)
				left = new TreeWordSet(w);
			else
				left.add(w);
		}
		else if(word.compareTo(w) < 0) {
			if (right == null)
				right = new TreeWordSet(w);
			else
				right.add(w);
		}
	}
	
	public TreeWordSet getLeft() {
		return left;
	}
	
	public TreeWordSet getRight() {
		return right;
	}
	
	public Word getValue() {
		return this.word;
	}
	
	@Override
	public Iterator<Word> iterator() {
		return new TreeWordSetIterator(this);
	}
	
	public void print() {
		if(left != null)
			left.print();
		System.out.print(word + " - "); // in order print value
		if(right != null) // visit
			right.print();
	}

	@Override
	public boolean contains(Word w) throws NullPointerException { // Recursive method.
		if(word == null)
			throw new NullPointerException("The word gave in parameter is null."); // Handle exception.
		if(word.compareTo(w) > 0) { // Check all the branches of the tree to find an equal word than 'w'.
			if(left == null)
				return false;
			else
				return left.contains(w);
		}
		else if(word.compareTo(w) < 0) {
			if (right == null)
				return false;
			else
				return right.contains(w);
		}
		return true;
	}
	
	private int getSize(TreeWordSet t) {
		if(t == null) return 0;
		return getSize(t.left) + 1 + getSize(t.right);
	}

	@Override
	public int size() { // Return the number of elements contained in the tree.
		return getSize(this);
	}
}