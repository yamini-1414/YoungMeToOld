package Tree;
public class BSTBasic {
static class Node{
	int data;
	Node left;
	Node right;

Node(int data){
	this.data  = data;
	this.left = this.right = null;
}
}
public static boolean isBST(Node root) {
	if(root==null)
		return true;
    if(root.left!=null && findMax(root.left).data>root.data)
    	return false;
    if(root.right!=null && findMin(root.right)<root.data)
    	return false;
    if(!isBST(root.left) || !isBST(root.right))
    	return false;
    return true;
}
static int prev = Integer.MIN_VALUE;
public static boolean isBST1(Node root) {
	if(root==null) return true;
	if(!isBST1(root.left))
		return false;
	if(root.data<prev) {
		return false;
	}
	System.out.print(root.data+" ");
	prev = root.data;
	return isBST1(root.right);
}
public static Node delete(int key,Node root) {
	if(root==null)
		return null;
	if(key<root.data)
		root.left = delete(key,root.left);
	else if(key>root.data)
		root.right = delete(key,root.right);
	else {
		if(root.left!=null && root.right!=null) {
			 root.data= findMin(root.right);
			root.right = delete(root.data,root.right);
			return root;
		}else if(root.left==null && root.right!=null)
			   return root.right;
		else if(root.left!=null && root.right==null)
			  return root.left;
		else 
		    root = null;
	}
	return root;
	
}
public static int findMin(Node root) {
	if(root==null)
		return 0;
	else {
		if(root.left==null)
			return root.data;
		else return findMin(root.left);
	}
}
public static Node findMax(Node root) {
	if(root==null)
		return null;
	else {
		if(root.right==null)
			return root;
		else return findMax(root.right);
	}
}
public static Node insert(int key,Node root) {
	if(root==null) {
		root = new Node(key);
		return root;
	}else {
		if(key<root.data)
			root.left = insert(key,root.left);
		else
			root.right = insert(key,root.right);
	}
	return root;
}
public static void inorder(Node root) {
	if(root!=null) {
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
}
public static void main(String[] args) {
	Node root=null;
	root = insert(20,root);
	root = insert(10,root);
	root = insert(5,root);
	root = insert(2,root);
	root = insert(3,root);
	System.out.println(isBST1(root));
}
}

