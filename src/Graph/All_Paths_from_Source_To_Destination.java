package Graph;

import java.util.ArrayList;
import java.util.HashMap;

public class All_Paths_from_Source_To_Destination {
	   static HashMap<Integer,ArrayList<Integer>> map;
	  public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
		  map = new HashMap<Integer,ArrayList<Integer>>();
		  
		  for(int i=0;i<n;i++)
			  map.put(i,new ArrayList<Integer>());
		  for(int[] edge:edges) {
			  map.get(edge[0]).add(edge[1]);
		  }
		  System.out.println(map);
		  boolean[] visited = new boolean[n];
		  boolean[] traversed = new boolean[n];
		  return dfs(source,destination,traversed,visited);
	    }
	boolean dfs(int source,int destination,boolean[] traversed,boolean[] visited) {
		if(traversed[source])
			return false;
		if(map.get(source).size()==0 && source!=destination)
			return false;
		traversed[source] = true;
		for(Integer nextNode: map.get(source)) {
			if(!visited[nextNode] && !dfs(nextNode,destination,traversed,visited))
				return false;
		}
		visited[source] = true;
		return true;
	}
	  public static void main(String[] args) {
		  All_Paths_from_Source_To_Destination solution = new All_Paths_from_Source_To_Destination();
	        boolean b = solution.leadsToDestination(3, new int[][] {{0, 1}, {0, 2}}, 0, 2);
	        System.out.println(b);
	    }
}
