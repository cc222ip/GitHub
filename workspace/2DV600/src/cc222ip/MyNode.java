package cc222ip;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import graphs.Node;

/**
 * @author Chris_Chevalier
 *
 */
public class MyNode<E> extends Node<E> {
	private Set<Node<E>> preds = new HashSet<Node<E>>(); // Sets to stock predecessors and successors.
	private Set<Node<E>> succs = new HashSet<Node<E>>();

	/**
	 * @param item
	 */
	protected MyNode(E item) { super(item); } // "MyNode" constructor.

	@Override
	public boolean hasSucc(Node<E> node) {
		for(Node<E> tmp : succs) // Check all the successors of "this" node.
            if(tmp.item() == node.item()) return true; // Then, return true if the entry node have same value than one of the successors.
        return false;
	} 

	@Override
	public int outDegree() { return succs.size(); } // Out degree corresponds of the number of successors of "this" node.

	@Override
	public Iterator<Node<E>> succsOf() { return succs.iterator(); } // Allows to check easier all the successors of a node.

	@Override
	public boolean hasPred(Node<E> node) {
		for(Node<E> tmp : preds) // Check all the predecessors of "this" node.
            if(tmp.item() == node.item()) return true; // Then, return true if the entry node have same value than one of the predecessors.
        return false;
	}

	@Override
	public int inDegree() { return preds.size(); } // In degree corresponds of the number of predecessors of "this" node.

	@Override
	public Iterator<Node<E>> predsOf() { return preds.iterator(); } // Allows to check easier all the predecessors of a node.

	@Override
	protected void addSucc(Node<E> succ) { succs.add(succ); } // Adds a successor to a node.

	@Override
	protected void removeSucc(Node<E> succ) { succs.remove(succ); } // Removes a successor to a node.

	@Override
	protected void addPred(Node<E> pred) { preds.add(pred); } // Adds a predecessor to a node.

	@Override
	protected void removePred(Node<E> pred) { preds.remove(pred); } // Removes a predecessor to a node.

	@Override
	protected void disconnect() {
		preds.clear(); // A disconnect node have no predecessors or successors.
		succs.clear();
	}
}
