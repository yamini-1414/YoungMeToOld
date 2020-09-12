package N_Array_Tree;
import java.util.ArrayList;
import java.util.HashMap;

public class Diameter {
	HashMap<Integer,ArrayList<Integer>> map;
	static int maxCount;
public int treeDiameter(int[][] edges) {
	 map = new HashMap<Integer,ArrayList<Integer>>();
	 
	 
	 for(int[] edge:edges) {
		 if(map.get(edge[0])==null)
			 map.put(edge[0],new ArrayList<Integer>());
		 map.get(edge[0]).add(edge[1]);
	 }
	  boolean[] visited = new boolean[map.size()];
	  findDiameter(visited,0);
	  return maxCount;
    }
// This is wrong or according to some different question. Please refer to GFG.
    public int findDiameter(boolean[] visited,int src) {
    	if(visited[src]) return 0;
    	visited[src] = true;
    	if(map.get(src).size()==0)
    		return 1;
    	int max1=0;int max2=0; 
    	for(int next:map.get(src)) {
    		int h = findDiameter(visited,next);
    		if(h>max1) {
    			max2 = max1;
    			max1 = h;
    		}else if(h>max2)
    		     max2 = h;
    	}
    	maxCount = Math.max(maxCount, 1+max1+max2);
    	return max1+1;
    }
    public int getHeight(int node) {
    	if(map.get(node)==null)
    		return 0;
    	int maxDepth =0;
    	for(int child: map.get(node)) {
    		maxDepth = Math.max(maxDepth, getHeight(child));
    	}
    	return maxDepth+1;
    }
}
