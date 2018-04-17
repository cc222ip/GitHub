package cc222ip_assign1;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Chris_Chevalier
 *
 */
public class HighLow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random rand = new Random();
		int N = rand.nextInt(100) + 1;
		while(N % 2 == 0) // While the number is even.
			N = rand.nextInt(100); // The program selects a random odd number between 1 and 100.
		
		Scanner scan = new Scanner(System.in);
		
		int x = 0;
		int turn = 1;
		
		while(N != x) {
			if(turn == 11)
				break;
			
			System.out.print("Guest " + turn + ": ");
			x = scan.nextInt(); // The player tries to guess the N value.
			
			if(N > x) // The program gives a hint, "higher" or "lower".
				System.out.println("Hint: higher");
			else if(N < x)
				System.out.println("Hint: lower");
			turn++;
		}
		
		if(turn == 11) { // The program is terminated after 10 guesses with a suitable comment.
			System.out.println();
			System.out.println("You didn't found the good number in 10 trials.");
			System.out.println("The right result is " + N);
		}
		
		if(N == x) {
			System.out.println();
			System.out.println("Correct after only " + (turn - 1) + " guesses - Brilliant!");
		}
	}
}
