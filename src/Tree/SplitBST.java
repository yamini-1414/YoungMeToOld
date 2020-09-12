package Tree;

public class SplitBST {
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val){
			this.val = val;
			this.left = this.right=null;
		}
	}
	/// I didnt get the solution. Copied from LeetCode solution
	static TreeNode[] res;
	 public static  TreeNode[] splitBST(TreeNode root, int V) {
		 if (root == null)
	            return new TreeNode[]{null, null};
	        else if (root.val <= V) {
	            TreeNode[] bns = splitBST(root.right, V);
	            root.right = bns[0];
	            bns[0] = root;
	            return bns;
	        } else {
	            TreeNode[] bns = splitBST(root.left, V);
	            root.left = bns[1];
	            bns[1] = root;
	            return bns;
	        }
	        
	    }
	 public static void inorder(TreeNode root) {
		 if(root!=null) {
			 inorder(root.left);
			 System.out.print(root.val+" ");
			 inorder(root.right);
		 }
	 }
  public static void main(String[] args) {
	  TreeNode root = new TreeNode(4);
	  root.left = new TreeNode(2);
	  root.left.left = new TreeNode(1);
	  root.left.right = new TreeNode(3);
	  root.right = new TreeNode(5);
	  root.right.left = new TreeNode(6);
	  root.right.right = new TreeNode(7);
	  TreeNode[] r = splitBST(root,5);
	  System.out.println(r[0].val+" "+r[1].val);
	  inorder(r[0]);
  }
}
