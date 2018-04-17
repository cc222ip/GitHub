package cc222ip_assign1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Chris_Chevalier
 *
 */
public class Histogram {
	/**
	 * @param args
	 * @throws FileNotFoundException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws FileNotFoundException, NumberFormatException {
		File f = new File(args[0]);
		int T[] = new int[11];
		int n = 0;
		try(Scanner sc = new Scanner(f)) {
			while(sc.hasNext()) {
				try {
					n = Integer.parseInt(sc.nextLine());
					if(n <= 200 && n > 0) {
						if(n <= 10) {
							T[0]++;
						}
						else if(n <= 20){
							T[1]++;
						}
						else if(n <= 30){
							T[2]++;
						}
						else if(n <= 40){
							T[3]++;
						}
						else if(n <= 50){
							T[4]++;
						}
						else if(n <= 60){
							T[5]++;
						}
						else if(n <= 70){
							T[6]++;
						}
						else if(n <= 80){
							T[7]++;
						}
						else if(n <= 90){
							T[8]++;
						}
						else if(n <= 100){
							T[9]++;
						}
						else if(n <= 200){
							T[10]++;
						}
					}
				}
				
				catch (NumberFormatException e) {
					System.out.println("There is a text which is not a number in your file.");
					System.out.println(e.getMessage());
				}
			}
		}
		catch (FileNotFoundException e) { e. printStackTrace (); }
		
		int first = T[0] + T[1] + T[2] + T[3] + T[4] + T[5] + T[6] + T[7] + T[8] + T[9];
		
		// Display :
		
		System.out.println("Reading integers from the file: " + f.getAbsolutePath());
		System.out.println("Number of integers in the interval [1,100]: " + first);
		System.out.println("in the interval [101,200]: " + T[10]);

		System.out.println();
		System.out.println("Histogram");
		System.out.print("1 - 10   | ");
		for(int i = 0; i < T[0]; i++) {
			System.out.print('*');
		}
		System.out.println();
		System.out.print("11 - 20  | ");
		for(int i = 0; i < T[1]; i++) {
			System.out.print('*');
		}
		System.out.println();
		System.out.print("21 - 30  | ");
		for(int i = 0; i < T[2]; i++) {
			System.out.print('*');
		}
		System.out.println();
		System.out.print("31 - 40  | ");
		for(int i = 0; i < T[3]; i++) {
			System.out.print('*');
		}
		System.out.println();
		System.out.print("41 - 50  | ");
		for(int i = 0; i < T[4]; i++) {
			System.out.print('*');
		}
		System.out.println();
		System.out.print("51 - 60  | ");
		for(int i = 0; i < T[5]; i++) {
			System.out.print('*');
		}
		System.out.println();
		System.out.print("61 - 70  | ");
		for(int i = 0; i < T[6]; i++) {
			System.out.print('*');
		}
		System.out.println();
		System.out.print("71 - 80  | ");
		for(int i = 0; i < T[7]; i++) {
			System.out.print('*');
		}
		System.out.println();
		System.out.print("81 - 90  | ");
		for(int i = 0; i < T[8]; i++) {
			System.out.print('*');
		}
		System.out.println();
		System.out.print("91 - 100 | ");
		for(int i = 0; i < T[9]; i++) {
			System.out.print('*');
		}
		System.out.println();
		System.out.print("101 - 200| ");
		for(int i = 0; i < T[10]; i++) {
			System.out.print('*');
		}
	}
}
