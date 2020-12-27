package Graph;

import java.util.Arrays;

public class HamiltonCycle {
public boolean isSafe(int[] path,int[][] graph,int pos,int v) {
	if(graph[path[pos-1]][v]!=1)
		return false;
	for(int i=0;i<pos;i++)
		if(path[i]==v)
			return false;
	return true;
}
public void hamiltonCycle(int[][] graph) {
	int[] path = new int[graph.length];
	Arrays.fill(path,-1);
	path[0] = 0;
	
}
public boolean hamiltonUtil(int[][] graph,int pos,int[] path) {
	if(pos==graph.length) {
		if(graph[path[pos-1]][path[0]]==1)
			return true;
		else
			return false;
	}
	for(int i=1;i<graph.length;i++) {
		if(isSafe(path,graph,pos,i)) {
			path[pos] = i;
			if(hamiltonUtil(graph,pos+1,path))
				return true;
			path[pos] = -1;
		}
	}
	return false;
}
}
