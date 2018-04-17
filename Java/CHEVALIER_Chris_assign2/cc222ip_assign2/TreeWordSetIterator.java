package cc222ip_assign2;

import java.util.Iterator;

/**
 * @author Chris_Chevalier
 *
 */
public class TreeWordSetIterator implements Iterator<Word> { // Class used to provide a good iterato to the Tree WordSet

	private Word[] t; // A word array.
	private int pos = 0; // An integer index.
	
	/**
	 * @param tws
	 */
	public TreeWordSetIterator(TreeWordSet tws) { // TreeWordSetIterator Constructor.
		t = new Word[tws.size()];
		way(tws);
		pos = 0;
	}
	
	/**
	 * @param tws
	 */
	private void way(TreeWordSet tws) {
		if(tws.getLeft() != null)
			way(tws.getLeft());
		t[pos++] = tws.getValue();
		if(tws.getRight() != null)
			way(tws.getRight());
	}
	
	@Override
	public boolean hasNext() {
		return pos < t.length;
	}

	@Override
	public Word next() {
		return t[pos++];
	}

}
