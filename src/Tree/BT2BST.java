package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BT2BST {
static class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
		this.left = this.right = null;
	}
}
static List<Integer> nodes;
public static void inorder(Node root) {
	if(root!=null) {
		inorder(root.left);
		nodes.add(root.data);
		inorder(root.right);
	}
}
public static Node buildTree(List<Integer> nodes,int start,int end) {
	if(start>end)
		return null;
	int mid = (start+end)/2;
	Node new_node = new Node(nodes.get(mid));
	new_node.left = buildTree(nodes,start,mid-1);
	new_node.right = buildTree(nodes,mid+1,end);
	return new_node;
}
public static Node bt2bst(Node root) {
	  if(root==null)
		  return null;
	  nodes = new ArrayList<Integer>();
	  inorder(root);
	  Collections.sort(nodes);
	  return buildTree(nodes,0,nodes.size()-1);
}
}
