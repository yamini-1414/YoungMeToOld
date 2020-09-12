package Graph;
import java.util.ArrayList;

public class CycleDirectedDFS {


static boolean isCycle(ArrayList<ArrayList<Integer>> list,int V) {
	boolean[] visited = new boolean[V];
	boolean[] recStack = new boolean[V];
	
	for(int i=0;i<V;i++) {
		if(isCycleUtil(list,recStack,visited,i)) {
			return true;
		}
	}
	return false;
}
static boolean isCycleUtil(ArrayList<ArrayList<Integer>> list,boolean[] visited,boolean[] recStack,int src) {
	if(recStack[src])
		return true;
	if(visited[src])
		return false;
	visited[src] = true;
	recStack[src] = true;
	
	ArrayList<Integer> arr = new ArrayList<Integer>();
	arr = list.get(src);
	for(int i=0;i<arr.size();i++) {
		if(!visited[arr.get(i)])
			if(isCycleUtil(list,visited,recStack,arr.get(i)))
				return true;
	}
	return false;
}
}