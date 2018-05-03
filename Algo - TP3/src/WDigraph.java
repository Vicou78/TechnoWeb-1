import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WDigraph extends Graph<Integer> {
	public static final double DEFAULT_WEIGHT = 1.0;
	
	
	
	private final Map<Integer, List<DirectedEdge>> adjList = new TreeMap<>();
	
	
	
	public WDigraph() {
		super();
	}


	@Override
	public void addEdge(Integer s, Integer t) {
		addEdge(s,t,DEFAULT_WEIGHT);
	}


	public void addEdge(Integer s, Integer t, double weight) {
		
		if(!adjList.containsKey(s)) 
			addVertex(s);
		
		if(!adjList.containsKey(t))
			addVertex(t);
		
		List<DirectedEdge> out = adjList.get(s);
		out.add(new DirectedEdge(s,t,weight));
	}


	@Override
	public void addVertex(Integer v) {
		this.n++;
		adjList.put(v, new LinkedList<>());
	}


	@Override
	public List<Integer> vertices() {
		List<Integer> out = new ArrayList<>(adjList.keySet());
		return out;
	}
	
	public List<DirectedEdge> edges() {
		List<DirectedEdge> out = new ArrayList<>();
		for(List<DirectedEdge> l: adjList.values())
			out.addAll(l);
		
		return out;
	}


	@Override
	public List<Integer> inNeighbors(Integer v) {
		
		return null;
	}


	@Override
	public List<Integer> outNeighbors(Integer v) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int inDegree(Integer v) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int outDegree(Integer v) {
		// TODO Auto-generated method stub
		return 0;
	}


	public List<DirectedEdge> outEdges(Integer s) {
		List<DirectedEdge> deList = new ArrayList<>();
		deList.addAll(adjList.get(s));
		return deList;
	}


	public double weight(Integer s, Integer d) {
		
		List<DirectedEdge> nbs = adjList.get(s);
		
		for(DirectedEdge de: nbs)
			if(de.to()==d.intValue())
				return de.weight();
		
		return Double.MAX_VALUE;
	}

}