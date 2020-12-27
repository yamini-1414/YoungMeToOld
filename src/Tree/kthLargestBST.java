package Tree;

import java.util.ArrayList;

public class kthLargestBST {
static class Node{
	int data;
	Node left; Node right;
	Node(int data){
		this.data= data;
		this.left = this.right = null;
	}
}
static ArrayList<Node> nodes;
public int kthSmallest(Node root,int k) {
	nodes = new ArrayList<Node>();
	kthSmallestUtil(root);
	return nodes.get(k-1).data;
}
public void kthSmallestUtil(Node root) {
	if(root==null)
		return ;
	kthSmallestUtil(root.left);
	nodes.add(root);
	kthSmallestUtil(root.right);
}
}
