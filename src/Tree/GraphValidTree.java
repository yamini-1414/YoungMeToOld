package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphValidTree {
	HashMap<Integer,List<Integer>> graph;
public boolean validTree(int n, int[][] edges) {
        graph = new HashMap<Integer,List<Integer>>();
        for(int i=0;i<n;i++)
        	graph.put(i,new ArrayList<Integer>());
        for(int[] edge:edges) {
        	graph.get(edge[0]).add(edge[1]);
        	graph.get(edge[1]).add(edge[0]);
        }
        int[] parent = new int[n];
        parent[0] = 0; // Make the starting node as its parent.
        if(!dfs(parent,0)) return false;
        //Check for disconnectivity of nodes
        for(int i=0;i<n;i++) {
        	if(parent[i]==-1)
        		return false;
        }
        return true;
    }
boolean dfs(int[] parent,int src) {
	//Check if there is a cycle
	for(int next : graph.get(src)) {
		//If a node is already visited then it should be parent of src
		if(parent[next] != -1 && parent[src] != next)
			return false;
	
	if(parent[next]==-1) {
		parent[next] = src;
		//If node is not visited ,then call dfs on that node.
	if(!dfs(parent,next)) return false;
	}
	}
	return true;
}
}
