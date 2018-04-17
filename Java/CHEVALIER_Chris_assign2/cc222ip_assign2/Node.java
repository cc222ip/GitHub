package cc222ip_assign2;

/**
 * @author Chris_Chevalier
 *
 * @param <E>
 */
public class Node<E> { // Node represents an element in the queue.

	public E element; // A node is composed by an element (value) and his next node.
	public Node<E> next;
	
	/**
	 * @param element
	 * @param next
	 */
	public Node(E element, Node<E> next) { // Constructor of the node with the element and the next in parameter.
		this.element = element;
		this.next = next;
	}
	
	public E getElement() { // Method to have an access to the element of a node.
		return element;
	}
	
	public Node<E> getNext() { // Method to have an access to the next of a node.
		return next;
	}
}
