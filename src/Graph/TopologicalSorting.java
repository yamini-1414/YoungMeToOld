package Graph;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSorting {
public static class Graph{
	int V;
	LinkedList<Integer>[] adjList;
	Graph(int V){
		this.V = V;
		this.adjList = new LinkedList[V];
		for(int i=0;i<V;i++)
			adjList[i] = new LinkedList<Integer>();
	}
	public  void topologicalSortUtil(boolean[] visited,int i,Stack<Integer> s) {
		if(visited[i])
			return;
		visited[i] = true;
		if(adjList[i].size()>0) {
			for(int j=0;j<adjList[i].size();j++) 
				topologicalSortUtil(visited,adjList[i].get(j),s);
			
		}
		//In topological sort, we need to add first to complete the node first and then its dependencies,quite opposite to dfs logic.
		s.push(i);
	}
	public void topologicalSort(int n) {
		boolean[] visited = new boolean[n];
		Stack<Integer> s = new Stack<Integer>();
		for(int i=0;i<n;i++) {
			if(visited[i]==false)
				topologicalSortUtil(visited,i,s);
		}
		
		while(!s.isEmpty())
			System.out.print(s.pop()+" ");
	}
	public static void main(String[] args) {
	  Graph g = new Graph(4);
	  g.adjList[0].add(2);
	  g.adjList[1].add(0);
	  g.adjList[1].add(3);
	  g.adjList[3].add(0);
	  g.topologicalSort(4);
	}
}
}
