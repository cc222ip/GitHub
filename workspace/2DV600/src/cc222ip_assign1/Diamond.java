package cc222ip_assign1;

import java.util.Scanner;

/**
 * @author Chris_Chevalier
 *
 */
public class Diamond {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		Scanner scan = new Scanner(System.in);
		int size = 0;
		System.out.print("Provide a new number: ");
		size = scan.nextInt();
		
		while(size % 2 == 0 || size <= 0) { // The user chooses an arbitrary positive and odd integer (read from the keyboard).
			System.out.println("Error. The provide number must be posivite and odd."); // Error message if the provided integer isn't positive and odd.
			System.out.print("Provide a new number: ");
			size = scan.nextInt();
		}
		
		int middle = (size - 1) / 2;
		int countStars = 1;
		
		for(int i = 0; i < size; i++) { // Represents height.
			for(int j = 0; j < middle; j++)
				System.out.print(' ');
			for(int j = 0; j < countStars; j++)
				System.out.print('*'); // Prints a "diamond".
			
			if(i < (size - 1) / 2) {
				middle--;
				countStars += 2;
			}
			else {
				middle++;
				countStars -= 2;
			}
			System.out.println();
		}
	}
}
