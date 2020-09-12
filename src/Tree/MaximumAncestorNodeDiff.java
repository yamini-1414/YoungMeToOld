package Tree;

public class MaximumAncestorNodeDiff {
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	static int maxDiff;
	 public int maxAncestorDiff(TreeNode root) {
	        maxDiff=Integer.MIN_VALUE;
	        maxAncestorUtil(root,root.val,root.val);
	        return maxDiff;
	    }
	 public void maxAncestorUtil(TreeNode root,int max,int min) {
		 if(root==null)
			 return;
		 maxDiff = Math.max(maxDiff, Math.abs(max- min));
		 if(root.left!=null)
			 maxAncestorUtil(root.left,Math.max(root.left.val, max),Math.min(root.left.val, min));
		 if(root.right!=null)
			 maxAncestorUtil(root.right,Math.max(root.right.val, max),Math.min(root.right.val, min));
		 
	 }
}
