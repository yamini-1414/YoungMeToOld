package Tree;
public class Array2BST {
static class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data= data;
		this.left = this.right = null;
	}
}
public static  Node convert(int[] arr,int start,int end) {
	if(start>end)
		return null;
	int mid = (start+end)/2; 
	Node root = new Node(arr[mid]);
	root.left = convert(arr,start,mid-1);
	root.right = convert(arr,mid+1,end);
	return root;
}
public static void preorder(Node root) {
	if(root!=null) {
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
}
public static void main(String[] args) {
	int[] arr = {1,2,3,4,5,6,7};
	Node root = convert(arr,0,arr.length-1);
	preorder(root);
}
}
