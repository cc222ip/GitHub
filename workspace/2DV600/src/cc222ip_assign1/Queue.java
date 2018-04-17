package cc222ip_assign1;

import java.util.Iterator;

/**
 * @author Chris_Chevalier
 *
 */
public class Queue implements QueueInterface {
	private static Node head;
	private Node tail;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue q = new Queue();
		q.enqueue(2);
		q.enqueue(1);
		q.enqueue(7);
		
		try {
			q.display();
			System.out.println("The value of the head is " + q.first());
			System.out.println("The value of the tail is " + q.last());
			q.dequeue();
			System.out.println("- After dequeue: ");
			q.display();
			System.out.println("- Display with iterators: ");
			Iterator <?> ite = q.iterator();
			while(ite.hasNext()) {
				System.out.print(ite.next() + " -> ");
			}
	    }
	    catch (Exception e) {
	    	System.out.println(e.getMessage());
	    }
	}
	
	public Queue() {
		head = null;
		tail = null;
	}
	
	public void display() {
		Node n = new Node();
		n = head;
		while(n != null) {
			System.out.print(n.value + " -> ");
			n = n.next;
		}
		System.out.println();
	}

	public int size() {
		int s = 0;
		Node n = head;
		while(n != null) {
			s++;
			n = n.next;
		}
		return s;
	}

	public boolean isEmpty() {
		if(head == null) 
			return true;
		return false;
	}

	public void enqueue(Object n) {
		if(head == null) { // Add first element
			head = new Node(n);
			tail = head;
		}
		else {
			tail.next = new Node(n); // Attach new node
			tail = tail.next; // Update tail
		}
	}

	public Object dequeue() throws IndexOutOfBoundsException {
	    if(this.isEmpty())
	        throw new IndexOutOfBoundsException("The queue is empty.");
		else
			head = head.next;
		return null;
	}

	public Object first() throws IndexOutOfBoundsException {
		if(this.isEmpty())
	        throw new IndexOutOfBoundsException("The queue is empty.");
		else
			return head.value;
	}

	public Object last() throws IndexOutOfBoundsException {
		if(this.isEmpty())
	        throw new IndexOutOfBoundsException("The queue is empty.");
		else
			return tail.value;
	}

	public boolean contains(Object o) {
		Node n = new Node();
		while(n != null) {
			if(n == o) {
				return true;
			}
			n = n.next;
		}
		return false;
	}

	public Iterator<?> iterator() {
		return new ListIterator();
	}
	
	/**
	 * @author Chris_Chevalier
	 *
	 */
	class ListIterator implements Iterator <Object> { // Inner iterator class private
		Node node = head; // First node is head
		
		public Object next() {
			Object val = node.value;
			node = node.next;
			return val;
		}
		
		public boolean hasNext() {
			return node != null;
		}
	}

}
