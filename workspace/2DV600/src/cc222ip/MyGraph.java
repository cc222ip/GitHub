package cc222ip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import graphs.DirectedGraph;
import graphs.Node;

/**
 * @author Chris_Chevalier
 *
 */
public class MyGraph<E> implements DirectedGraph<E> {
	private Map<E, MyNode<E>> item2node; // Map to stock nodes and their value.
	private Set<Node<E>> heads; // 2 sets to stock heads and tails nodes.
	private Set<Node<E>> tails;
	
	public MyGraph() { // MyGraph constructor: Build an empty graph.
		item2node = new HashMap<E, MyNode<E>>();
		heads = new HashSet<Node<E>>();
		tails = new HashSet<Node<E>>();
	}
	
	public static void main(String args[]) {
		DirectedGraph<Integer> g = new MyGraph<Integer>(); // We create a graph to test methods.
		
		try {
			g.addNodeFor(1); // Add some nodes.
			g.addNodeFor(2);
			g.addNodeFor(3);
			
			g.addEdgeFor(1, 3); // add edges.
			g.addEdgeFor(3, 1);
			g.addEdgeFor(1, 2);
			g.addEdgeFor(2, 3);
				
		} catch(Exception e) { e.printStackTrace(); } // Handles exception.
		
		System.out.println("Number of nodes: " + g.nodeCount());
		System.out.println("Number of edges: " + g.edgeCount());
		if(g.containsNodeFor(2)) System.out.println("The Node value 2 is in the graph.");
		if(g.containsEdgeFor(1, 2)) System.out.println("The Edge between values 1 and 2 is in the graph.");
		
		
		System.out.println("Let's see all the items: " + g.allItems() + "\n");
		
		System.out.println("Graph before removing:");
		System.out.println(g); // Clear display of nodes and relations between (edges).
		
		g.removeEdgeFor(1, 3);
		g.removeNodeFor(2);
		
		System.out.println("Graph after removing:");
		System.out.print(g);
	}
	
	@Override
	public Node<E> addNodeFor(E item) {
		if(item == null)
			throw new NullPointerException("Received null as input"); // Handles exception
		if(!item2node.containsKey(item)) { // If not added before
			MyNode<E> n = new MyNode<E>(item); // Create the new node to add.
			heads.add(n); // It's a disconnect node, so it's a head and a tail also.
			tails.add(n);
			item2node.put(item, n); // We add the node with his value ("item") in the graph.
		}
		return item2node.get(item);
	}

	@Override
	public Node<E> getNodeFor(E item) {
		if(item == null)
			throw new NullPointerException("Received null as input"); // Handles exception
		if(!item2node.containsKey(item))
			throw new NullPointerException("The node with value " + item + " isn't in the graph."); // Handles exception
		
		return item2node.get(item); // If the node with the value "item" is in the graph, return the value.
	}

	@Override
	public boolean addEdgeFor(E from, E to) {
		if(from == null || to == null)
			throw new NullPointerException("Received null as input"); // Handles exception
		
		MyNode<E> src = (MyNode<E>) addNodeFor(from); // Create 2 nodes to stock "from" and "to" value.
		MyNode<E> tgt = (MyNode<E>) addNodeFor(to);
		
		if(src.hasSucc(tgt)) // If edge is already added, return false.
			return false;
		else {
			src.addSucc(tgt); // "src" is the successor of "tgt", so, "tgt" is the predecessor of "src".
			tgt.addPred(src);
			
			tails.remove(src); // So the "from" node just can be a head.
			heads.remove(tgt); // And the "to" node just can be a tail.
		}
		return true; // Return true to inform that the edge add is a success.
	}

	@Override
	public boolean containsNodeFor(E item) {
		if(item == null)
			throw new NullPointerException("Received null as input"); // Handles exception
		
		if(item2node.get(item) == null) return false; // If we find no node with "item" value, return false.
		return true; // Otherwise return true.
	}

	@Override
	public int nodeCount() { return item2node.size(); } // The number of node correspond to the size of the map which stock the graph.

	@Override
	public Iterator<Node<E>> iterator() {
		List<Node<E>> arr = new ArrayList<Node<E>>(item2node.values()); // We use an array to stock values of the map.
		return arr.iterator();
	} 

	@Override
	public Iterator<Node<E>> heads() { return heads.iterator(); }

	@Override
	public int headCount() { return heads.size(); } // The number of heads correspond to the size of the heads set.

	@Override
	public Iterator<Node<E>> tails() { return tails.iterator(); }

	@Override
	public int tailCount() { return tails.size(); } // The number of tails correspond to the size of the tails set.

	@Override
	public List<E> allItems() {
		List<E> l = new ArrayList<E>(); // We use an array list to stock values of the graph.
		for(MyNode<E> n : item2node.values())
			l.add(n.item()); // We add each value in the list and return it.
		return l;
	}

	@Override
	public int edgeCount() {
		int edges = 0; // Stocks the number of edges in the graph.
		for(MyNode<E> n : item2node.values())
			edges += n.outDegree(); // We add the out degree value of each node to return the number of edges.
		return edges;
	}

	@Override
	public void removeNodeFor(E item) {
		if(item == null)
			throw new NullPointerException("Received null as input"); // Handles exception
		
		MyNode<E> n = item2node.get(item);
		Iterator<Node<E>> itePred = n.predsOf();
		while(itePred.hasNext()) { // Check predecessors of node which his value is "item".
			MyNode<E> pred = (MyNode<E>) itePred.next();
			pred.removeSucc(n); // Remove the 'n' node for each predecessor node.
			if(pred.isTail()) // If we detect that the current predecessor is a tail, add to tail's set.
				tails.add(pred);
		}
			
		Iterator<Node<E>> iteSucc = n.succsOf();
		while(iteSucc.hasNext()) { // Check successors of node which his value is "item".
			MyNode<E> succ = (MyNode<E>) iteSucc.next();
			succ.removePred(n); // Remove the 'n' node for each successor node.
			if(succ.isHead()) // If we detect that the current successor is a head, add to head's set.
				heads.add(succ);
		}
		n.disconnect(); // Remove definitely the 'n' node from different data structure.
		heads.remove(n);
		tails.remove(n);
		item2node.remove(item);
	}

	@Override
	public boolean containsEdgeFor(E from, E to) {
		if(from == null || to == null)
			throw new NullPointerException("Received null as input"); // Handles exception
		
		if(containsNodeFor(from) && containsNodeFor(to)) { // Check if nodes with value "from" and "to" are in the graph.
			if(item2node.get(from).hasSucc(item2node.get(to))) // Check if "from" node is a predecessor of "to" node.
					return true;
		}
		return false;
	}

	@Override
	public boolean removeEdgeFor(E from, E to) {
		if(from == null || to == null)
			throw new NullPointerException("Received null as input"); // Handles exception
		
		if(containsEdgeFor(from, to)) { // Check if the edge to remove exists in the graph.
			MyNode<E> nFrom = item2node.get(from); // Puts the concerned node in variables.
			MyNode<E> nTo =  item2node.get(to);
			nFrom.removeSucc(nTo); // Remove node successor "to" of node "from".
			nTo.removePred(nFrom); // Remove node predecessor "from" of node "to".
			
			// Check if the concerned nodes are head or tail.
			if(nFrom.isTail())
				tails.add(nFrom);
			if(nFrom.isHead())
				heads.add(nFrom);
			if(nTo.isTail())
				tails.add(nTo);
			if(nTo.isHead())
				heads.add(nTo);
			return true; // Return true if the remove is done.
		}
		return false;
	}
	
	@Override
	public String toString() { // Return a clear display of nodes and edges of the graph.
		String str = new String();
		str += "Nodes: ";
		for(MyNode<E> n : item2node.values()) // Display nodes.
			str += "[" + n + "] ";
		str += "\n\nEdges:\n";
		for(MyNode<E> n : item2node.values()) { // For each node, display predecessors.
			Iterator<Node<E>> itePred = n.predsOf();
			str += "Predecessors of node [" + n + "] => ";	
			if(!itePred.hasNext()) str += "no predecessor";
			while(itePred.hasNext())
				str += "[" + itePred.next() + "] ";
			str += "\n";
			
			Iterator<Node<E>> iteSucc = n.succsOf(); // For each node, display successors.
			str += "Successors of node [" + n + "] => ";
			if(!iteSucc.hasNext()) str += "no successor";
			while(iteSucc.hasNext())
				str += "["+iteSucc.next()+"] ";
			str += "\n\n";	
		}
		return str;
	}
}
