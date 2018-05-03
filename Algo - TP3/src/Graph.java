

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;


/**
 * This class is an Abstract Graph. 
 * Types of Vertices (V) and Edges (E) are not defined by default. 
 * The only constraints on theses types are that Vertices must be Comparable ie. 
 * there must be a way to order vertices with one another. This is done through the use of the Comparable interface.
 *  
 * 
 * @author slefebvr
 *
 * @param <V>
 * @param <E>
 */
public abstract class Graph<V extends Comparable<V>> {
	
	protected int n;
	protected int m;
	
	
	public Graph(int nbVertices, int nbEdges) {
		this.n= nbVertices;
		this.m = nbEdges;
	}
	
	
	/**
	 * Initializes an empty graph
	 */
	public Graph() {
		this(0,0);
	}
	
	public int order() {
		return n;
	}
	
	public int size() {
		return m;
	}

	/**
	 * Adds the corresponding vertex if needed
	 * @param e
	 */
	public abstract void addEdge(V s, V t);
	
	/**
	 * Adds a vertex to the graph. On success n is increased
	 * @param v
	 */
	public abstract void addVertex(V v);
	
	/**
	 * 
	 * @return the list of the graph vertices
	 */
	public abstract List<V> vertices();
		
	/** 
	 * Return the list of v's neighbors
	 * @param v
	 */
	public abstract List<V> inNeighbors(V v);
	public abstract List<V> outNeighbors(V v);
		
	/**
	 * Returns the inbound degree of node v
	 * in case of undirected graph should return the same as outDegree
	 * @param v
	 * @return inbound degree of vertex v
	 */
	public abstract int inDegree(V v);
	public abstract int outDegree(V v);
	
	
	
	/**
	 * Returns true if the graph is connected
	 * can be more efficient. 
	 * @return
	 */
	public boolean isConnected() {
		return cc(this)==1;
	}
	
	private static<V extends Comparable<V>> void assign(V u, V root, Graph<V> g, Map<V, V> components) {
		if(!components.containsKey(u)) {
			components.put(u, root);
			List<V> in = g.inNeighbors(u);
			for(V v: in)
				assign(v, root,g,components);	
		}
	}
	
	/**
	 * Counts and returns the number of connected components
	 * Kosaraju's algorithm
	 * @param g
	 * @return
	 */
	public static<V extends Comparable<V>> int cc(Graph<V> g) {
		
		List<V> vertices = g.vertices(), 
				dfsOut= new ArrayList<>();
		Map<V, V> components = new TreeMap<>();
		dfs(g, vertices.get(0), dfsOut);
		
		for(V v : dfsOut)
			assign(v,v,g,components);
		
		Set<V> s = new HashSet<>();
		s.addAll(components.values());
		return s.size();
		
	}
	
	
	
	private static <V extends Comparable<V>> V findMin(List<V> l) {
		V min = l.get(0);
		for(V elem: l) {
			min = elem.compareTo(min) < 0 ? elem : min;
		}
		return min;
	}
	
	/**
	 * Returns the list of vertices ordered by DFS visit 
	 * 
	 * @param g
	 * @return
	 */
	public static<V extends Comparable<V>>  List<V> dfs(Graph<V> g) {
		List<V> out = new LinkedList<>(),
				vertices = g.vertices();
		
		for(V current: vertices) {
			if(!out.contains(current))
				dfs(g,current, out);
		}
		
		return out;
	}
	private static<V extends Comparable<V>>  void dfs(Graph<V> g, V start, List<V> out) {
		out.add(start);
		List<V> neighbors = g.outNeighbors(start);
		while(neighbors.size() > 0) {
			V v = findMin(neighbors);
			neighbors.remove(v);
			if(!out.contains(v)) {
				dfs(g,v,out);
			}
 		}
	}
	

	/**
	 * Iterative function for bfs 
	 * @param g
	 * @return
	 */
	public static<V extends Comparable<V>> List<V> bfs(Graph<V> g, V start) {
		List<V> vertices = g.vertices();
		List<V> out = new LinkedList<>();
		if(vertices.size() > 0) {
			while(vertices.size() > 0) {
				bfs(g, start, vertices, out);
			}
		}
				
		return out;
		
	}


	private static<V extends Comparable<V>> void bfs(Graph<V> g, V v, List<V> vertices, List<V> out) {
		Queue<V> q = new LinkedList<>();
		q.add(v);
		do {
			V current = q.poll();
			out.add(current);
			
			List<V> neighbors = g.outNeighbors(current);
			for(V n: neighbors) {
				if(vertices.contains(n)) {
					vertices.remove(n);
					q.add(n);
				}
			}
			
		} while(q.size() > 0);
	}

}
