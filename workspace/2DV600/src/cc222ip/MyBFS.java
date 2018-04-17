package cc222ip;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import graphs.BFS;
import graphs.DirectedGraph;
import graphs.Node;

public class MyBFS<E> implements BFS<E> {
	private int counter = 0;
	
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
			
			BFS<Integer> d = new MyBFS<Integer>();
			System.out.println("dfs(g) => " + d.bfs(g));
			
		} catch(Exception e) { e.printStackTrace(); } // Handles exception.
	}
	
	@Override
	public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) {
		if(graph == null || root == null)
			throw new NullPointerException("Received null as input"); // Handles exception
		
		List<Node<E>> visited = new ArrayList<Node<E>>(); // List to stock visited nodes.
		List<Node<E>> bfsList = new ArrayList<Node<E>>(); // List to stock nodes during bfs method.
		Set<Node<E>> set = new HashSet<Node<E>>(); // Set to stock all reachable nodes from a given node.
		set.add(root); // In first, we add the root to the set.
		return bfs(visited, bfsList, set);
	}

	@Override
	public List<Node<E>> bfs(DirectedGraph<E> graph) {
		if(graph == null)
			throw new NullPointerException("Received null as input"); // Handles exception
		
		List<Node<E>> visited = new ArrayList<Node<E>>(); // List to stock visited nodes.
		List<Node<E>> bfsList = new ArrayList<Node<E>>(); // List to stock nodes during bfs method.
		Set<Node<E>> set = new HashSet<Node<E>>(); // Set to stock all reachable nodes from a given node.
		for(Node<E> n : graph) { // For each node in the graph.
			set.add(n);
			bfsList = bfs(visited, bfsList, set); // We run the recursive BFS method with our new set.
		}
		return bfsList;	
	}
	
	private List<Node<E>> bfs(List<Node<E>> visited, List<Node<E>> bfsList, Set<Node<E>> set) {
		Iterator<Node<E>> setIte = set.iterator();
		set = new HashSet<Node<E>>(); // We create a new set to stock successors of each node.
		while(setIte.hasNext()) { // For each node in the set.
			Node<E> n = setIte.next();
			if(!visited.contains(n)) {
				n.num = counter++;
				visited.add(n); // The current node is now visited.
				bfsList.add(n); // We don't forget to add it in the BFS list.
			}
			Iterator<Node<E>> succs = n.succsOf();
			while(succs.hasNext()) { // For each successor of current node.
				Node<E> s = succs.next();
				if(!visited.contains(s))
					set.add(s); // We add it in the set if it isn't already visited.
			}
		}
		if(!set.isEmpty())
			bfs(visited, bfsList, set);
		return bfsList;
	}
}
