import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DjikstraSP {
		
	boolean [] marked;
	int [] previous;
	double [] distance;
	Integer s;
	WDigraph g;
	
	
	
	
	
	public boolean verifyNonNegative(WDigraph g) {
		
		for(DirectedEdge de: g.edges()) {
			if(de.weight() < 0.0)
				return false;
		}
		
		return true;
		
	}
	
	private void init(WDigraph g, Integer s) { 
		marked   = new boolean[g.order()];
		distance = new double[g.order()];
		Arrays.fill(distance, Double.MAX_VALUE);
		distance[s-1] = 0.0;
		this.s   = s;
		this.g   = g;
		
	}
	
	
	/**
	 * Computes the Dijkstra shortest path.
	 * This algorithm fails if there are multiple connected components in the graph...
	 * 
	 * @param g
	 * @param s
	 */
	public void djikstraSP(WDigraph g, Integer s) {
		init(g, s);
		int totalMarked = 0;
		do {
			int a = findMin(distance, marked);
			marked[a] = true;
			totalMarked++;
			List<Integer> nb = g.outNeighbors(a+1);
			for(Integer n: nb) {
				if(!marked[n-1]) {
					double d = distance[a] + g.weight(a+1, n); 
					distance[n-1] = distance[n] < d ? distance[n] : d;
				}
			}
			
		} while(totalMarked< g.order());
		
	}

	private static Integer findMin(double[] distance, boolean [] marked) {
		int m = 0,i=0;
		
		while(i< distance.length) {
			if(!marked[i])
				m = distance[m] < distance[i] ? m : i;
			i++;
		}
		return m; 
	}
	public double distTo(int s) {
		return distance[s-1];
	}
	
	public boolean hasPathTo(Integer v) {
		return marked[v-1];
	}
	
	public void printSV(int v) {
		int cur, prev  = v;
		if(!hasPathTo(v)) {
			System.out.println("No path to " + v);
			return;
		}
		
		do {
			cur = previous[prev-1];
			System.out.println(prev + " <- ");
			prev = cur;
		} while(cur!=s);
					
	}
}
