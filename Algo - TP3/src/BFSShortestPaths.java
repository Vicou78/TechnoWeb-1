import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSShortestPaths {
	//Test
	boolean [] marked;
	int [] previous;
	int [] distance;
	Integer s;
	Digraph g; 
	
	public void bfs(Digraph g, Integer s) {
		this.s = s;
		this.g = g;
		
		marked = new boolean[g.order()];
		previous = new int[g.order()];
		distance = new int[g.order()];
		
		
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		
		do {
			Integer current = q.poll();
						
			List<Integer> neighbors = g.outNeighbors(current);
			for(Integer n: neighbors) {
				if(!marked[n-1]) {
					marked[n-1]= true;
					previous[n-1] = current;
					distance[n-1] = distance[previous[n-1]-1] +1 ;
					q.add(n);
				}
			}
			
		} while(q.size() > 0);	
	}
	
	public int distTo(int s) {
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
