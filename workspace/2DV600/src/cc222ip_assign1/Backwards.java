package cc222ip_assign1;

import java. util .Scanner; // Make the Scanner class available

/**
 * @author Chris_Chevalier
 *
 */
public class Backwards { // Reads a line of text from the keyboard and then prints the sentence in reverse order on the screen.

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Provide some text: ");
		StringBuilder text = new StringBuilder(scan.nextLine()); // Reads a line of text from the keyboard
		text.reverse();
		System.out.println("Display: " + text); // Prints the sentence in reverse order on the screen
	}

}
