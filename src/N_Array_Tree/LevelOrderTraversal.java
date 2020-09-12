package N_Array_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
static class TreeNode{
	int val;
    List<TreeNode> children;
    TreeNode(int val){
    	this.val = val;
    	this.children = new ArrayList<TreeNode>();
    }
}
public List<List<Integer>> levelOrderTraversal(TreeNode root) {
	if(root==null)
		return null;
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	Queue<TreeNode> q = new LinkedList<TreeNode>();
	List<Integer> curr = new ArrayList<Integer>();
	q.offer(root);
	while(!q.isEmpty()) {
		TreeNode temp = q.poll();
		if(temp!=null) {
			curr.add(temp.val);
			for(TreeNode children:temp.children)
				q.add(children);
		}else {
			res.add(new ArrayList<Integer>(curr));
			curr.clear();
		}
	}
	return res;
}
}
