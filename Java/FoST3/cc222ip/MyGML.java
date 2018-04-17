package cc222ip;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import graphs.DirectedGraph;
import graphs.GML;
import graphs.Node;

public class MyGML<E> extends GML<E> {
	
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
		
		MyGML<Integer> gml = new MyGML<Integer>(g);
		System.out.println(gml.toGML());
		gml.dumpGML();
	}
	
	Map<Node<E>, Integer> map = new HashMap<>();

	public MyGML(DirectedGraph<E> dg) {
		super(dg);
	}

	@Override
	public String toGML() {
		String gml = "graph [\n";
		/*gml += "\tcomment \"This is a graph test\"\n";
		gml += "\tdirected 1\n";
		gml += "\tlabel \"Hej, I'm a graph test\"\n";*/
		
		int id = 0;
		
		for(E item : graph.allItems()) {
			Node<E> n = graph.getNodeFor(item);
			gml += "\tnode [ \n";
			gml += "\t\tid " + id + "\n";
			gml += "\t\tlabel \"node " + n + "\"\n" ;
			gml += "\t]\n";
			map.put(n, id);
			id++;
		}
		
		id = 0;
		
		for(E item : graph.allItems()) {
			Node<E> n = graph.getNodeFor(item);
			Iterator<Node<E>> iteSucc = n.succsOf();
			while(iteSucc.hasNext()) {
				int tmp = map.get(iteSucc.next());
				gml += "\tedge [\n";
				gml += "\t\tsource " + id;
				gml += "\n\t\ttarget " + tmp + "\n";
				gml += "\t\tlabel \"Edge from " + id + " to node " + tmp + "\"\n";
				gml += "\t]\n";
			}
			id++;
		}
		gml += "]";
		return gml; // Return the complete graph represented with GML.
	}
}
