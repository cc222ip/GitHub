package cc222ip_assign1;

import java.util.Scanner;

/**
 * @author Chris_Chevalier
 *
 */
public class CountDigits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Provide a positive number: ");
		
		int N = scan.nextInt(); // N is read from the keyboard.
		int pos = N % 10; // Stock the first digit.
		int zero = 0, odd = 0, even = 0, sum = 0;
		
		while(N > 0) {
			sum += pos;
			if(pos == 0)
				zero += 1;
			else if(pos % 2 == 0)
				even += 1;
			else
				odd += 1;
			
			N /= 10;
			pos = N % 10;
		}
		
		// Display of the number of zeros, odd digits, even digits and the sum of all digits :
		
		System.out.println("Zeros: " + zero);
		System.out.println("Odd: " + odd);
		System.out.println("Even: " + even);
		System.out.println("Sum: " + sum);
	}
}
