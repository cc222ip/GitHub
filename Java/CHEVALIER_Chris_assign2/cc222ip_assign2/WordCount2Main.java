package cc222ip_assign2;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Chris_Chevalier
 *
 */
public class WordCount2Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashWordSet hws = new HashWordSet(); // Creation of the both new sets.
		TreeWordSet tws = new TreeWordSet(new Word("Start:"));
		
		File file = new File("words.txt");
		Scanner fileScan = null;
		
		try {
			fileScan = new Scanner(file); // Open the reading file "words.txt".
			while(fileScan.hasNext()) { // Read each words contained in the file.
				Word w = new Word(fileScan.next()); // Each word is a Word and not a String.
				hws.add(w); // Add each word in the both sets.
				tws.add(w);
			}
		}
		catch (IOException e) { e.printStackTrace(); } // Handle the exception.
		System.out.println("Number of unique words in the file (gave by the hash word set): " + hws.size()); // Test if the size reflect the correct number of unique words in the file. 
		System.out.println("Number of unique words in the file (gave by the tree word set): " + (tws.size() - 1)); // "-1" because we don't want include the root word in the number of unique words.
		
		Iterator<Word> ite = tws.iterator(); // Display the sorted list of words contained in the TreeWordSet with an iterator.
		while(ite.hasNext())
			System.out.println(ite.next());
	}
}
