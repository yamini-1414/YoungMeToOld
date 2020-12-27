package Tree;

public class isSubTree {
	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	 public boolean isSubtree(TreeNode s, TreeNode t) {
	        if(s==null) return false;
	        if(t==null) return true;
	        if(isEqual(s,t))
	            return true;
	        return isSubtree(s.left,t) || isSubtree(s.right,t);
	    }
	    public boolean isEqual(TreeNode s, TreeNode t){
	        if(s==null && t==null) return true;
	        if(s==null || t==null) return false;
	        return s.val==t.val && isEqual(s.left,t.left) && isEqual(s.right,t.right);
	    }
}
