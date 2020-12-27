package Stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
	// Definition for a Node.
	static class Node {
	    public int val;
	    public List<Node> neighbors;

	    public Node() {}

	    public Node(int _val,List<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	};
  	public Node cloneGraph(Node node){
		HashMap<Node,Node> map = new HashMap<Node,Node>();
		//ArrayList<Node> arr = new ArrayList<Node>();
		return dfs(node,map);
		
	}
	static Node dfs(Node node, HashMap<Node, Node> map) {
		  if(map.containsKey(node))
			  return map.get(node);
		  Node clone_node = new Node(node.val,new ArrayList<Node>());
		  map.put(node, clone_node);
		  for(int i=0;i<node.neighbors.size();i++)
			  clone_node.neighbors.add(dfs(node.neighbors.get(i),map));
		  return clone_node;
	}
}
