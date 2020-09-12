package Tree;


public class DeepestLeavesSum {
	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	   public int deepestLeavesSum(TreeNode root) {
	        if(root==null) return 0;
	        if(root.left==null && root.right==null){
	            return root.val;
	        }
	        int lheight = depth(root.left);
	        int rheight = depth(root.right);
	        if(lheight==rheight)
	            return deepestLeavesSum(root.left)+deepestLeavesSum(root.right);
	        else if(lheight>rheight)
	            return deepestLeavesSum(root.left);
	         return deepestLeavesSum(root.right);
	    }public int depth(TreeNode root){
	        if(root==null) return 0;
	        return Math.max(depth(root.left),depth(root.right))+1;
	    }
}
