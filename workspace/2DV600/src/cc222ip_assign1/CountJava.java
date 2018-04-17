package cc222ip_assign1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Chris_Chevalier
 *
 */
public class CountJava {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		File start_dir = new File(args[0]);
		System.out.println("Root director: " + start_dir.getAbsolutePath());
		visitDir(start_dir);
	}

	/**
	 * @param dir
	 * @throws FileNotFoundException
	 */
	private static void visitDir(File dir) throws FileNotFoundException {
		File[]sub_dirs = dir.listFiles();
		int java = 0, line = 0;
		for(int i = 0; i < sub_dirs.length; i++) {
			File sub = sub_dirs[i];
			if(sub.isDirectory()) {
				visitDir(sub);
			}
			else if(sub.isFile()) {
				if(sub.getName().endsWith(".java")) {
					java++;
					try(Scanner sc = new Scanner(sub)) {
						while(sc.hasNext()) {
							sc.nextLine();
							line++;
						}
					}
					catch (FileNotFoundException e) { e.printStackTrace(); }
					System.out.println("  " + java + " " + sub.getName() + "  lines = " + line);
					line = 0;
				}
			}
		}
	}
}