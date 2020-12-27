package Tree;
public class Array2BT {
static class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		 this.data = data;
		 this.left = this.right = null;
	}
}
public Node constructBT(int[] arr,Node root,int i) {
	if(i<arr.length) {
		root = new Node(arr[i]);
		root.left = constructBT(arr,root.left,2*i+1);
		root.right = constructBT(arr,root.right,2*i+2);
	}
	return root;
}
}
