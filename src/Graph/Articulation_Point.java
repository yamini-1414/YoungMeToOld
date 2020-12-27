package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Articulation_Point {
	static Map<Integer,List<Integer>> map;
	static int time;
public static List<Integer> articulationPoint(int[][] edges,int numNodes) {
	if(edges.length==0) return null;
	List<Integer> res = new ArrayList<Integer>();
	map = new HashMap<Integer,List<Integer>>();
	time =0;
	for(int[] edge:edges) {
		if(!map.containsKey(edge[0]))
			map.put(edge[0],new ArrayList<Integer>());
		if(!map.containsKey(edge[1]))
		map.put(edge[1],new ArrayList<Integer>());
		map.get(edge[0]).add(edge[1]);
		map.get(edge[1]).add(edge[0]);
	}
	int[] parent = new int[numNodes];
	boolean[] visited = new boolean[numNodes];
	int[] disc = new int[numNodes];
	int[] low = new int[numNodes];
	Arrays.fill(parent,-1);
	for(int i=0;i<numNodes;i++)
		if(!visited[i])
			dfsUtil(parent,visited,i,disc,low,res);
		return res;
}
public static void dfsUtil(int[] parent,boolean[] visited,int u,int[] disc,int[] low,List<Integer> res) {
	int child = 0;
	visited[u] = true;
	disc[u]=low[u]= ++time;
	for(int v:map.get(u)) {
		if(!visited[v]) {
			child++;
			parent[v] = u;
			dfsUtil(parent,visited,v,disc,low,res);
			low[u] = Math.min(low[u], low[v]);
			//1.Check for root node having atleast 2 children
			if(parent[u]==-1 && child>1)
				res.add(u);
			//2.If low value of one of its edges is greater than discovery value of u
			// which means its doesnt have any back edge
			if(parent[u]!=-1 && low[v]>=disc[u])
				res.add(u);
		}else if(v!=parent[u]) {
			low[u] = Math.min(low[u], disc[v]);
		}
	}
}
public static void main(String[] args) {
	int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};
	System.out.println(articulationPoint(edges,7));
}
}
