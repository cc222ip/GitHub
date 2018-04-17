package cc222ip_assign1;

/**
 * @author Chris_Chevalier
 *
 */
public class Node {

	public Object value;
	public Node next;
	
	public Node() {
		value = 0;
		next = null;
	}
	
	/**
	 * @param vvalue
	 */
	public Node(Object vvalue) {
		value = vvalue;
		next = null;
	}
}
