package Tree;

public class BinaryTreeLCs {
	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val= val;
			this.left = this.right = null;
		}
	}
	  static int maxLen;
	    public int longestConsecutive(TreeNode root) {
	        if(root==null) return 0;
	        maxLen=Integer.MIN_VALUE;
	        pathLength(root,0,1);
	        return maxLen;
	    }
	    public void pathLength(TreeNode root,int val,int length){
	        if(root==null) return;
	//System.out.println(root.val+" "+length);
	        if(root.val==val)
	            length++;
	        else
	           length=1;
	        maxLen = Math.max(maxLen,length);
	        pathLength(root.left,root.val+1,length);
	        pathLength(root.right,root.val+1,length);
	    }
}
