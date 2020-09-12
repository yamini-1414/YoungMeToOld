package Tree;


public class Merge2BST {
static class Node{
	int data;
	Node left;Node right;
	Node(int data){
		this.data = data;
		this.left  = this.right = null;
	}
}
static Node prev1 = null;
static Node prev2 = null;
public void merge(Node root1,Node root2) {
	if(root1==null && root2==null)
		return;
	if(root1==null) {
		inorder(root2);
		return;
	}
	if(root2==null) {
		inorder(root1);
		return;
	}
	Node curr1 = root1;
	while(curr1.left!=null) {
		prev1 = curr1;
		curr1 = curr1.left;
	}
	Node curr2 = root2;
	while(curr2.left!=null) {
		prev2=curr2;
		curr2= curr2.left;
	}
		if(curr1.data<=curr2.data) {
			System.out.print(curr1.data+" ");
			if(prev1==null) {
				merge(root1.right,root2);
			}else {
				prev1.left = curr1.right;
				merge(root1,root2);
			}
		}else {
			System.out.print(curr2.data+" ");
			if(prev2==null) {
				merge(root1,root2.right);
			}else {
				prev2.left = curr2.right;
				merge(root1,root2);
			}
		}
	
}
public static void inorder(Node root) {
	if(root!=null) {
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
}
}
