package Tree;

public class InorderSuccessor {
static class TreeNode{
	int val;
	TreeNode left; TreeNode right;
	TreeNode(int val){
		this.val = val;
		this.left = this.right = null;
	}
}
public TreeNode inorderSuccessor(TreeNode root,TreeNode p) {
	if(p.right!=null)
		return getMin(p.right);
	TreeNode succ = null;
	while(root!=null) {
		if(p.val<root.val) {
			succ = root;
			root = root.left;
		}else if(p.val>root.val)
			root = root.right;
		else 
			break;
	}
	return succ;
}
public TreeNode getMin(TreeNode root) {
	if(root==null)
		return null;
	while(root.left!=null)
		root = root.left;
	return root;
	
}
}
