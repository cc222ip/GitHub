package cc222ip_assign1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Chris_Chevalier
 *
 */
public class CountChars {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		int upper = 0, lower = 0, whitespace = 0, other = 0, number = 0;
		File file = new File(args[0]);
		
		Scanner fileScan = null;
		try {
			fileScan = new Scanner(file);
			while(fileScan.hasNext()) {
				String str = fileScan.nextLine();
				for(int i = 0; i < str.length(); i++) {
					if(Character.isUpperCase(str.charAt(i))) // Counts the upper case letters
						upper++;
					else if(Character.isLowerCase(str.charAt(i))) // Counts the lower case letters
						lower++;
					else if(Character.isDigit(str.charAt(i))) // Counts the numbers
						number++;
					else if(Character.isWhitespace(str.charAt(i))) // Counts the "Whitespace" (i.e., space, tab, and return)
						whitespace++;
					else
						other++; // Counts the others characters 
				}
			}
		}
		catch (IOException e) { e.printStackTrace(); }
		
		System.out.println("Upper case letters: " + upper);
		System.out.println("Lower case letters: " + lower);
		System.out.println("Whitespace: " + whitespace);
		System.out.println("Other case: " + other);
		System.out.println("Numbers: " + number);
	}
}
