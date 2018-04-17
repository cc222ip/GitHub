package cc222ip_assign2;

/**
 * @author Chris_Chevalier
 *
 */
public class ArrayIntList extends AbstractIntCollection implements IntList {
	
	@Override
	public void add(int n) {
		if(values.length <= size) { // Check if the array is not full and resize it if it's necessary.
			resize();
		}
		values[size++] = n; // Add the n element (integer) at the end of the array list.
	}
	
	@Override
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		if(!checkIndex(index, size)) // Check if the index parameter is correct and run the exception if it's necessary.
			throw new IndexOutOfBoundsException("Error. The index is incorrect.");
		if(values.length < size + 1) // Check if the size of the list is higher than the length of the array.
			resize(); // Resize the array if it's necessary.
		size++; // Increase the list size.
		for(int i = size; i > index; i--)
			values[i] = values[i - 1]; // Push the elements after the index gave in parameter to introduce the new element.
		values[index] = n; // Add the element at the right place.
	}

	@Override
	public void remove(int index) throws IndexOutOfBoundsException {
		if(!checkIndex(index, size)) // Check if the index parameter is correct and run the exception if it's necessary.
			throw new IndexOutOfBoundsException("Error. The index is incorrect.");
		for(int i = index; i <= size; i++)
			values[i] = values[i + 1];
		size--; // Decrease the list size.
	}

	@Override
	public int get(int index) throws IndexOutOfBoundsException {
		if(!checkIndex(index, size)) // Check if the index parameter is correct and run the exception if it's necessary.
			throw new IndexOutOfBoundsException("Error. The index is incorrect.");
		return values[index]; // Return the element at the index give in parameter.
	}

	@Override
	public int indexOf(int n) {
		for(int i = 0; i <= size; i++) {
			if(values[i] == n)
				return i; // Return the element found at the n index.
		}
		return -1;
	}
}