package N_Array_Tree;

import java.util.ArrayList;
import java.util.List;

public class Depth_Narray {
static class Node{
	int val;
	List<Node> children;
	Node(int val){
		this.val = val;
		this.children = new ArrayList<Node>();
	}
}
static int getHeight(Node root) {
	 if(root==null)
		 return 0;
	 int maxDepth =0;
	 for(Node children: root.children)
		 maxDepth = Math.max(maxDepth, getHeight(children));
	 //include the node, so add 1
	 return maxDepth+1;
		 
}    
}
