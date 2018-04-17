package cc222ip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;

public class MyDFS<E> implements DFS<E> {
	
	private List<Node<E>> visited; // List to stock visited nodes.
	private int counter = 0;
	
	public MyDFS() { // "MyDFS" constructor.
		visited = new ArrayList<Node<E>>();
	}
	
	public static void main(String args[]) {
		DirectedGraph<Integer> g = new MyGraph<Integer>(); // We create a graph to test methods.
		
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
			
			DFS<Integer> d = new MyDFS<Integer>();
			System.out.println("dfs(g) => " + d.dfs(g));
			
			System.out.println("Post Order(g) => " + d.postOrder(g));
			if(d.isCyclic(g))
				System.out.println("This graph is cyclic");
			System.out.println(d.topSort(g));
			
		} catch(Exception e) { e.printStackTrace(); } // Handles exception.
	}
	@Override
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) { // Depth-first Search:
		if(graph == null)
			throw new NullPointerException("Received null as input"); // Handles exception
		
		visited.clear(); // Empty visited list before dfs.
        dfs(root); // We use an other (recursive) method to perform dfs correctly.
        return visited;
    }
	
	/**
	 * @param r
	 */
	private void dfs(Node<E> n) {
		n.num = counter++;
        visited.add(n); // The current node is now visited.
        Iterator<Node<E>> iteSucc = n.succsOf();
        while(iteSucc.hasNext()) { // For each successors of node 'r'.
            Node<E> s = iteSucc.next();
            if(!visited.contains(s)) // If the next node isn't visited -> recursive.
            	dfs(s);
        }
    }

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph) { // Depth-first Traversal:
    	if(graph == null)
			throw new NullPointerException("Received null as input"); // Handles exception
    	
    	visited.clear(); // Empty visited list before dfs.
        for(Node<E> n : graph) { // For each node in the graph.
            if(!visited.contains(n)) // If 'n' is not visited.
            	dfs(n); // Then dfs(n);
        }
        return visited;
    }

	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
		if(g == null || root == null)
			throw new NullPointerException("Received null as input"); // Handles exception
		
		List<Node<E>> poList = new ArrayList<Node<E>>(); // List to stock node in post-order.
		visited.clear(); // Empty visited list before post Order.
		postOrder(root, poList); // We use an other (recursive) method to perform post order correctly.
		return poList;
	}
	
	/**
	 * @param n
	 */
	private void postOrder(Node<E> n, List<Node<E>> poList) { // Basically a DFS traversal.
        if(!visited.contains(n)) {
        	visited.add(n); // Mark 'n' as visited.
            Iterator<Node<E>> s = n.succsOf();
            while(s.hasNext()) { // For each 's' (succOf(n)).
                Node<E> tmp = s.next();
                if(!poList.contains(tmp)) // If 's' not visited -> recursive
                	postOrder(tmp, poList);
            }
            n.num = counter++; // Each node has a unique post-order number.
            poList.add(n);
        }
    }

	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g) {
		if(g == null)
			throw new NullPointerException("Received null as input"); // Handles exception
		
		List<Node<E>> poList = new ArrayList<Node<E>>(); // List to stock node in post-order.
		visited.clear(); // Empty visited list before post Order.
		for(Node<E> n : g) {
			if(!visited.contains(n))
				postOrder(n, poList);
		}
		return poList;
	}

	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
		if(g == null)
			throw new NullPointerException("Received null as input"); // Handles exception
		
		List<Node<E>> poList = new ArrayList<Node<E>>(); // List to stock node in post-order.
		visited.clear(); // Empty visited list before post Order.
		for(Node<E> n : g) {
			if(attach_dfs_number)
				postOrder(n, poList);
		}
		return poList;
	}

	@Override
	public boolean isCyclic(DirectedGraph<E> graph) {
		if(graph == null)
			throw new NullPointerException("Received null as input"); // Handles exception
		
        for(Node<E> n : postOrder(graph)) { // For each node of post order graph.
            Iterator<Node<E>> iteSucc = n.succsOf();
            while(iteSucc.hasNext()) { // For each successors of each node.
                if(n.num <= iteSucc.next().num) // Here, a part of the graph is cyclic.
                    return true;
            }
        }
		return false;
	}

	@Override
	public List<Node<E>> topSort(DirectedGraph<E> graph) {
		if(graph == null)
			throw new NullPointerException("Received null as input"); // Handles exception
		if(isCyclic(graph)) // No topological ordering possible if graph is cyclic.
			throw new RuntimeException("The received graph is cyclic"); // Handles exception
		
		List<Node<E>> topSortList = postOrder(graph); // List to stock node in post-order.
		Collections.reverse(topSortList); // Topological order = reverse post-order.
		return topSortList;
	}
}
