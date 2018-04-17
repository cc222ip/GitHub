package cc222ip_assign1;

import java.util.Scanner;

/**
 * @author Chris_Chevalier
 *
 */
public class LargestK {

	/**
	 * @param args
	 */
	public static void main(String[] args) { // There is a mistake in the exercise text. With N = 110, we have K = 11 and not 20.
		Scanner scan = new Scanner(System.in);
		System.out.print("Provide a number: ");
		
		int N = scan.nextInt(); // N is read from the keyboard.
		int K = 0;
		int count = 0;
		
		while(K <= N) { // The largest K such that 0 + 2 + 4 + 6 + 8 + ... + K ≤ N
			count++;
			K += count * 2;
		}
		System.out.println("K = " + count);
	}
}
