package Tree;

public class Longest_Univalue_Path {
	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	   static int maxLen;
	    public int longestUnivaluePath(TreeNode root) {
	        if(root==null) return 0;
	        maxLen = Integer.MIN_VALUE;
	        maxLength(root);
	        return maxLen;
	    }
	    public int maxLength(TreeNode root){
	        if(root==null) return 0;
	        int left = maxLength(root.left);
	        int right = maxLength(root.right);
	        int left_max=0; int right_max=0;
	        if(root.left!=null && root.left.val==root.val)
	            left_max = left+1;
	        if(root.right!=null && root.right.val==root.val)
	            right_max = right+1;
	        maxLen = Math.max(maxLen ,left_max+right_max);
	        return Math.max(left_max,right_max);
	}
}
