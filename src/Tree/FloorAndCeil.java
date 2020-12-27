package Tree;

public class FloorAndCeil {
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data){
			this.left = this.right= null;
			this.data = data;
		}
	}
public static void floorAndCeil(TreeNode root,int floor,int ceil,int key) {
	if(root==null) {
		return;
	}
	if(root.data==key) {
		floor = root.data;
		ceil = root.data;
		return;
	}
	else if(key<root.data) {
		ceil = root.data;
		floorAndCeil(root.left,floor,ceil,key);
	}else {
		floor = root.data;
		floorAndCeil(root.right,floor,ceil,key);
	}
}
public static void main(String[] args) {
	TreeNode root = new TreeNode(8);
	root.left = new TreeNode(4);
	root.right = new TreeNode(10);
	root.left.left = new TreeNode(2);
	root.left.right = new TreeNode(6);
	root.right.left = new TreeNode(9);
	root.right.right = new TreeNode(10);
	int floor = -1; int ceil = -1;
	floorAndCeil(root,floor,ceil,7);
	System.out.println(floor);
}
}
