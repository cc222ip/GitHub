package cc222ip;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import graphs.ConnectedComponents;
import graphs.DirectedGraph;
import graphs.Node;

public class MyConnectedComponents<E> implements ConnectedComponents<E> {
    private Set<Node<E>> connected;
    private Set<Collection<Node<E>>> collectionSet;
    
    public MyConnectedComponents() {
    	connected  = new HashSet<Node<E>>();
    	collectionSet = new HashSet<Collection<Node<E>>>();
    }
    
    public static void main(String[] args) {
		DirectedGraph<Integer> g = new MyGraph<Integer>(); // We create a graph to test bfs methods.
		
		try {
			g.addNodeFor(1); // Add some nodes.
			g.addNodeFor(2);
			g.addNodeFor(3);
			g.addNodeFor(4);
			g.addNodeFor(5);
			g.addNodeFor(6);
			g.addNodeFor(7);
			
			g.addEdgeFor(1, 2); // add edges.
			g.addEdgeFor(1, 3);
			g.addEdgeFor(2, 4);
			g.addEdgeFor(3, 4);
			g.addEdgeFor(4, 2);
			g.addEdgeFor(4, 5);
			g.addEdgeFor(6, 4);
			g.addEdgeFor(5, 6);
			g.addEdgeFor(5, 7);
			
			ConnectedComponents<Integer> cc = new MyConnectedComponents<Integer>();
			System.out.println(cc.computeComponents(g));
			
		} catch(Exception e) { e.printStackTrace(); } // Handles exception.
    }

    @Override
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
        if(dg == null)
        	throw new NullPointerException("Received null as input"); // Handles exception
    	
    	collectionSet.clear(); // Don't forget to empty the set of collections before computes components.
        for(Node<E> n : dg) { // For each node in the graph.
            computeComponents(n); // Use the recursive method.
            for(Collection<Node<E>> coll : collectionSet) { // For each collection in our set.
                if(!Collections.disjoint(coll, connected)) { // If the both data structures have some elements in common.
                	coll.addAll(connected); // We had the connected nodes into the current collection.
                    connected = new HashSet<Node<E>>(); // So, we need a new connected set.
                }
            }
            if(!connected.isEmpty()) { // If there are some connected nodes.
            	collectionSet.add(connected); // Add it in the set of collections.
            	connected = new HashSet<Node<E>>(); // And open a new empty set of connected nodes.
            }
        }
        return collectionSet;
    }

    /**
     * @param node
     */
    private void computeComponents(Node<E> n) {
        connected.add(n); // Add the current node.
        Iterator<Node<E>> iteSucc = n.succsOf();
        while(iteSucc.hasNext()) { // For each successor of the current node.
            Node<E> s = iteSucc.next();
            if(!connected.contains(s)) // If the current successor is not connected => recursive (to connect it).
            	computeComponents(s);
        }
    }
}