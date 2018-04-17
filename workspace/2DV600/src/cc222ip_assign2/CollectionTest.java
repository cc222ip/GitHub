package cc222ip_assign2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Chris_Chevalier
 *
 */
public class CollectionTest {
	ArrayIntStack a;
	ArrayIntList A;
	@Before
	public void init() { // Initialize the both arrays.
		a = new ArrayIntStack();
		A = new ArrayIntList();
	}
	
	@Test
	public void pushTest() {
		assertTrue(a.isEmpty());
		for(int i = 0; i < 1000; i ++) // Push a lot of elements in the stack.
			a.push(i);
		assertFalse(a.isEmpty()); // Of course, the stack is not empty
		assertEquals(1000, a.size()); // and his current size is equal to the number of elements pushed: 1000.
	}
	
	@Test
	public void popTest() {
		for(int i = 0; i < 1000; i ++) // Push a lot of elements in the stack.
			a.push(i);
		assertFalse(a.isEmpty()); // Of course, the stack is not empty.
		for(int i = 0; i < 1000; i ++) // Pop all the elements out of the stack.
			a.pop();
		assertTrue(a.isEmpty()); // Now, the stack is empty
		assertEquals(0, a.size()); // and the size is equal at 0.
	}
	
	@Test
	public void peekTest() {
		for(int i = 0; i < 1000; i++) // Push a lot of elements in the stack.
			a.push(i);
		for(int i = 999; i > 0; i--) {
			assertEquals(a.peek(), i); // The peek element is equal to the element at the top of the stack.
			a.pop();
		}
	}
	
	@Test
	public void addTest() {
		assertTrue(A.isEmpty()); // The array list is empty.
		for(int i = 0; i < 1000; i++) // I add a lot of elements in the array list.
			A.add(i);
		assertFalse(A.isEmpty()); // The array is not yet empty.
		assertEquals(1000, A.size()); // The size is now equal to the number of elements in the array list.
	}
	
	@Test
	public void addAtTest() {
		for(int i = 0; i < 1000; i++) // I add a lot of elements in the array list.
			A.add(i);
		for(int i = 5; i < 10; i++) // I add 5 elements between the index 5 and 10.
			A.addAt(0, i);
		for(int i = 5; i < 10; i++) // Test if the 5 elements are clearly at their places.
			assertEquals(0, A.get(i));
		assertEquals(A.size, 1005); // Test if the size of the array list has increase of 5.
	}
	
	@Test
	public void removeTest() {
		for(int i = 0; i < 1000; i++) // I add a lot of elements in the array list.
			A.add(i);
		A.remove(10); // I remove the element at the index 10.
		assertEquals(A.get(10), 11); // The value of the index 10 is now equal to 11 and not 10. 10 is now removed.
	}

	@Test
	public void getTest() {
		for(int i = 0; i < 1000; i++) // I add a lot of elements in the array list.
			A.add(i);
		assertEquals(A.get(10), 10); // Test if the element at the index 10 is equal to 10 with get() method.
		assertEquals(A.get(100), 100); // Test if the element at the index 100 is equal to 100 with get() method.
	}
	
	@Test
	public void indexOfTest() {
		for(int i = 0; i < 1000; i++) // I add a lot of elements in the array list.
			A.add(i);
		assertEquals(A.indexOf(10), 10); // Test if the element at the index 100 is equal to 100 with indexOf() method.
		assertEquals(A.indexOf(100), 100); // Test if the element at the index 100 is equal to 100 with indexOf() method.
	}
}
