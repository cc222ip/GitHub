package cc222ip_assign2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {
	QueueMain<Integer> q;
	
	@Before
	public void init() {
		q = new QueueMain<Integer>();
	}

	@Test
	public void sizeTest() {
		assertEquals(0, q.size());
		for(int i = 0; i < 1000; i++)
			q.enqueue(i);
		assertEquals(1000, q.size());
	}
	
	@Test
	public void isEmptyTest() {
		assertTrue(q.isEmpty());
		for(int i = 0; i < 1000; i++)
			q.enqueue(i);
		assertFalse(q.isEmpty());
	}
	
	@Test
	public void enqueueTest() {
		for(int i = 0; i < 1000; i++)
			q.enqueue(i);
		assertEquals(1000, q.size());
	}
	
	@Test
	public void dequeueTest() {
		for(int i = 0; i < 1000; i++)
			q.enqueue(i);
		assertEquals(0, q.dequeue().intValue());
	}
	
	@Test
	public void firstTest() {
		q.enqueue(8);
		q.enqueue(7);
		assertEquals(8, q.first().intValue());
		q.dequeue();
		assertEquals(7, q.first().intValue());
	}
	
	@Test
	public void lastTest() {
		q.enqueue(8);
		assertEquals(8, q.last().intValue());
		q.enqueue(7);
		assertEquals(7, q.last().intValue());
	}
}
