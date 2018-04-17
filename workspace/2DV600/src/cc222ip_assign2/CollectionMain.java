package cc222ip_assign2;

/**
 * @author Chris_Chevalier
 *
 */
public class CollectionMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayIntStack stack = new ArrayIntStack(); // Create a new array int stack.
		stack.push(5); // Push elements (integers) inside.
		stack.push(8);
		stack.push(-4);
		try {
			stack.pop(); // Pop an element (-4).
			System.out.println("My stack: " + stack); // Display the stack.
			System.out.println("Peek: " + stack.peek()); // Display the element which is on the top of the stack.
		}
		catch(Exception e) { e.getMessage(); }

			
		ArrayIntList list = new ArrayIntList(); // Create a new array int list.
		list.add(2); // Add some elements inside.
		list.add(9);
		list.add(0);
		try {
			list.addAt(6, 2); // Add the element 6 at the index 2 (between the 9 and the 0).
			list.remove(1); // Remove the element at the first index : 9.
			System.out.println("My list: " + list); // Display the complete list.
			System.out.println("Test get: " + list.get(2)); // Display the element which is at the index 2.
			try {
				System.out.println("Test indexOf: " + list.indexOf(6)); // Display the index where the program find the element gave in parameter : 6.
			}
			catch(Exception e) { e.getMessage(); } // Handle the exception.
		}
		catch(Exception e) { e.getMessage(); } // Handle the exception.	
	}
}
