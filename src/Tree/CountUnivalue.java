package Tree;

public class CountUnivalue {
	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	  static int count;
	    public int countUnivalSubtrees(TreeNode root) {
	        if(root==null) return 0;
	        count=0;
	        countPaths(root);
	        return count;
	    }
	    public boolean countPaths(TreeNode root){
	        if(root.left==null && root.right==null) {count++;return true;};
	        boolean is_uniPath = true;
	        
	        if(root.left!=null)
	            is_uniPath = countPaths(root.left) && is_uniPath && root.left.val==root.val;
	        if(root.right!=null)
	            is_uniPath = countPaths(root.right) && is_uniPath && root.right.val== root.val;
	        if(!is_uniPath) return false;
	        count++;
	        return true;
	    }
}
