package cc222ip;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import graphs.DirectedGraph;
import graphs.Node;
import graphs.TransitiveClosure;

public class MyTransitiveClosure<E> implements TransitiveClosure<E> {
	private Map<Node<E>, Collection<Node<E>>> map;
	
    public MyTransitiveClosure() {
    	map = new HashMap<Node<E>, Collection<Node<E>>>();
    }
	
	public static void main(String[] args) {
		DirectedGraph<Integer> g = new MyGraph<Integer>(); // We create an oriented graph to test our new methods.
		
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
			g.addEdgeFor(4, 5);
			g.addEdgeFor(4, 6);
			g.addEdgeFor(5, 6);
			g.addEdgeFor(5, 7);
			
			MyTransitiveClosure<Integer> mtc = new MyTransitiveClosure<Integer>();
			System.out.println(mtc.computeClosure(g));
			
		} catch(Exception e) { e.printStackTrace(); } // Handles exception.
	}

	@Override
    public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
		if(dg == null)
			throw new NullPointerException("Received null as input"); // Handles exception
        
		List<Node<E>> l = new ArrayList<Node<E>>();
		for(Node<E> n : dg) { // For each node in the graph.
            l = new ArrayList<Node<E>>();
            dfs(n, l); // Lists all visited nodes in a DFS.
            map.put(n, l); // Save map entry (n, l).
        }
        return map; // The result is a map from nodes to reachable nodes.
    }

    private void dfs(Node<E> n, List<Node<E>> l) { // Classic DFS method.
        l.add(n);
        Iterator<Node<E>> ite = n.succsOf();
        while(ite.hasNext()) {
            Node<E> tmp = ite.next();
            if(!l.contains(tmp))
                dfs(tmp, l);
        }
    }
}
