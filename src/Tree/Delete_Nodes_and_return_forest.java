package Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Delete_Nodes_and_return_forest {
static class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val = val;
		this.left = this.right=null;
	}
}
List<TreeNode> res ;
HashSet<Integer> set;
public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    if(root==null)
    	return null;
    res = new ArrayList<TreeNode>();
    set = new HashSet<Integer>();
    
    for(int i=0;i<to_delete.length;i++)
    	set.add(to_delete[i]);
    
    if(!is_delete(root))
    	res.add(root);
    deleteNode(root);
    return res;
    	
}
public void deleteNode(TreeNode root) {
	if(root==null)
		return;
     boolean lNode = is_delete(root.left);
     boolean rNode = is_delete(root.right);
     if(is_delete(root)) {
    	 if(root.left!=null && !lNode)
    		 res.add(root.left);
    	 if(root.right!=null && !rNode)
    		 res.add(root.right);
     }else {
    	 if(root.left!=null && lNode)
    		 root.left=null;
    	 if(root.right!=null && rNode)
    		root.right=null;
     }
     deleteNode(root.left);
     deleteNode(root.right);
}
boolean is_delete(TreeNode node) {
	if(node==null)
		return false;
	return set.contains(node.val);
}
	
}
