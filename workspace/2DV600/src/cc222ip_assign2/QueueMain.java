package cc222ip_assign2;

import java.util.Iterator;

/**
 * @author Chris_Chevalier
 * @param <E>
 */
public class QueueMain<E> implements Queue<E> {
	private Node<E> head; // A queue is composed by a node which represents the head of the queue and an other which represents his tail.
	private Node<E> tail;
	private int size = 0; // It's interesting to know the size of the queue.

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QueueMain<Integer> q = new QueueMain<Integer>(); // Creation of a new Queue.
		q.enqueue(3); // Enqueue some elements.
		q.enqueue(8);
		q.enqueue(16);
		q.dequeue(); // Dequeue the first element (head).
		System.out.println("The queue has a size of "+ q.size()); // Display the current size of the queue.
		Iterator <Integer> ite = q.iterator(); // Display the queue with iterators.
		while(ite.hasNext())
			System.out.print(ite.next() + " -> ");
	}

	@Override
	public int size() { // Return current queue size. 
		return size;
	}

	@Override
	public boolean isEmpty() { // Check if the queue is empty. 
		if(size == 0)
			return true;
		return false;
	}

	@Override
	public void enqueue(E element) { // Adds element at the end of the queue.
		if(isEmpty()) { // If the queue is currently empty.
			head = tail = new Node<E>(element, null);
		}
		else if(head.getNext() == null) { // If there is just one element in the queue.
			Node<E> tmp = new Node<E>(element, null);
			head.next = tmp;
			tail = tmp;
		}
		else { // If there is more than one element in the queue.
			tail.next = new Node<E>(element, null);
			tail = tail.next;
		}
		size++; // Don't forget to increase the size of the queue !
	}

	@Override
	public E dequeue() throws IndexOutOfBoundsException {  // Return and remove first element of the queue.
		E tmp; // Variable to stock the first element before remove it.
		if(this.isEmpty()) // Check if the queue is empty to handle exception.
	        throw new IndexOutOfBoundsException("The queue is empty.");
		else {
			tmp = head.getElement(); // Stock the first element of the queue.
			head = head.getNext(); // Remove it.
		}
		size--; // Don't forget to decrease the size of the queue !
		return tmp; // Return the removed element.
	}

	@Override
	public E first() throws IndexOutOfBoundsException { // Return (without removing) the first element of the queue.
		if(this.isEmpty()) // Check if the queue is empty to handle exception.
	        throw new IndexOutOfBoundsException("The queue is empty.");
		else
			return head.getElement(); // Return the head's element.
	}

	@Override
	public E last() throws IndexOutOfBoundsException { // Return (without removing) the last element of the queue.
		if(this.isEmpty()) // Check if the queue is empty to handle exception.
	        throw new IndexOutOfBoundsException("The queue is empty.");
		else
			return tail.getElement(); // Return the tail's element.
	}

	public Iterator<E> iterator() { // Creation of the iterator of nodes.
		return new Iterator<E>() {
			Node<E> n = head;

			@Override
			public boolean hasNext() { // Check if the current iterator has a next.
				return n != null;
			}

			@Override
			public E next() { // The current position of the iterator switch to the next.
				E res = n.getElement();
				n = n.getNext();
				return res;
			}
		};
	}
}
