package cc222ip_assign1;

/**
 * @author Chris_Chevalier
 *
 * @param <T>
 */
public interface Iterator <T> {
	boolean hasNext(); // true if the iteration has more elements.
	T next(); // Returns the next element in the iteration.
}
