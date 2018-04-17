package cc222ip_assign2;

/**
 * @author Chris_Chevalier
 *
 */
public class ArrayIntStack extends AbstractIntCollection implements IntStack {
	
	@Override
	public void push(int n) {
		if(size == values.length) // Check if the array is not full and resize it if it's necessary.
			resize();
		values[size++] = n; // Add the n integer at the top of the stack.
	}

	@Override
	public int pop() throws IndexOutOfBoundsException {
		if(isEmpty()) // Check if the array is empty and run the exception if it's necessary.
			throw new IndexOutOfBoundsException("Error. The stack is empty.");
		int tmp = size - 1; // Stock the element which is on the top of the stack.
		values[tmp] = 0;
		size--; // Reduce the stack size.
		return tmp;
	}

	@Override
	public int peek() throws IndexOutOfBoundsException {
		if(isEmpty()) // Check if the array is empty and run the exception if it's necessary.
			throw new IndexOutOfBoundsException("Error. The stack is empty.");
		return values[size - 1]; // Return the element which is on the top the stack.
	}

}
