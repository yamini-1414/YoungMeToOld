package Tree;

import java.util.HashMap;

public class Maximum_Width {
	static class TreeNode{
		int val;
		TreeNode left; TreeNode right;
		TreeNode(int val){
			this.val = val;
			this.left = this.right= null;
		}
	}
static HashMap<Integer,Integer> map;
static int maxwidth;
public int widthOfBinaryTree(TreeNode root) {
    map = new HashMap<Integer,Integer>();
    maxwidth = Integer.MIN_VALUE;
    getWidth(root,0,0);
    return maxwidth;
}
public void getWidth(TreeNode root,int depth,int position) {
	if(root==null) return ;
	map.computeIfAbsent(depth, x->position);
	maxwidth = Math.max(maxwidth, position-map.get(depth)+1);
	getWidth(root,depth+1,2*position);
	getWidth(root,depth+1,2*position+1);
}
}
