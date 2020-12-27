package Tree;

public class isSymmetricTree {
	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int data){
			this.val = data;
			this.left= this.right = null;
		}
	}
	public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSame(root,root);
    }
    public boolean isSame(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        return root1.val==root2.val && isSame(root1.left,root2.right) &&
            isSame(root1.right,root2.left);
    }
}
