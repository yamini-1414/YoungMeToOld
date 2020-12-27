package Tree;

public class DiameterBT {
	static class TreeNode{
		int val;
		TreeNode left; TreeNode right;
		TreeNode(int val){
			this.val = val;
			this.left = this.right= null;
		}
	}
	public int diameterUtil(TreeNode root){
        if(root==null) return 0;
       return Math.max(Math.max(diameterUtil(root.left),diameterUtil(root.right)),
                       1+getHeight(root.left)+getHeight(root.right));
   }
   public int getHeight(TreeNode root){
       if(root==null)
           return 0;
       int leftHeight = getHeight(root.left);
       int rightHeight = getHeight(root.right);
       return Math.max(leftHeight,rightHeight)+1;
   }
}
