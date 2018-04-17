package cc222ip_assign2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Chris_Chevalier
 *
 */
public class WordCount1Main  {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		Set<Word> hashS = new HashSet<Word>(); // Create 2 empty sets of words.
		Set<Word> treeS = new TreeSet<Word>();
		
		File file = new File("words.txt");
		Scanner fileScan = null;
		
		try {
			fileScan = new Scanner(file); // open the "words.txt" file.
			while(fileScan.hasNext()) { // For each word in the file, add it in hash set AND tree set.
				Word w = new Word(fileScan.next());
				hashS.add(w);
				treeS.add(w);
			}
		} catch (IOException e) { e.printStackTrace(); } // Handle the exception.
		System.out.println("Number of unique words in the file (gave by the hash set): " + hashS.size());
		System.out.println("Number of unique words in the file (gave by the tree set): " + treeS.size());
		
		Iterator<Word> ite = treeS.iterator(); // We use an iterator to show that the tree is sorted.
		while(ite.hasNext())
			System.out.println(ite.next());
	}
}
