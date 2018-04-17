package cc222ip_assign2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Chris_Chevalier
 *
 */
public class IdentifyWordsMain {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("HistoryOfProgramming.txt");
		Scanner fileScan = null;
		
		try {
			fileScan = new Scanner(file); // Open the file "HistoryOfProgramming.txt" to read it.
		}
		catch (IOException e) { e.printStackTrace(); } // Handle the exception.
		
		try {
			final File wordFile = new File("words.txt"); 
	        try {
	        	wordFile.createNewFile();
	            final FileWriter writer = new FileWriter(wordFile); // Open the file "words.txt" to write it.
	            try {
	            	while(fileScan.hasNext()) { // Read all the line in the "HistoryOfProgramming.txt" file.
						String line = fileScan.nextLine();
						
						for(int i = 0; i < line.length(); i++) { // For each word in the line.
							if(Character.isUpperCase(line.charAt(i)) || Character.isLowerCase(line.charAt(i))) {
								writer.write(line.charAt(i)); // Rewrite characters in "words.txt" file.
							}
							else if (line.charAt(i) == 32) { // Handle the spaces characters.
								writer.write(" ");
							}
			            }
						writer.write("\r\n"); // Handle return to the line.
		            }
	            }
	            catch (Exception e) { e.printStackTrace(); } // Handle the exception.
	            finally {
	                writer.close(); // Close the file writer file.
	            }
	        }
	        catch (Exception e) { e.printStackTrace(); } // Handle the exception.
		}
		catch (Exception e) { e.printStackTrace(); } // Handle the exception.
	}
}