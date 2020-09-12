package Tree;

import java.util.ArrayList;

public class ConstructBT {
static class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
		this.left =this.right= null;
	}
}
static void inorder(Node root) {
	if(root!=null) {
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
}
static void preorder(Node root) {
	if(root!=null) {
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
}
static void postorder(Node root) {
	if(root!=null) {
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");
	}
}
static Node constructInorderPreorder(int[] ino,int[] pre) {
	if(pre.length ==0 || pre.length!=ino.length)
		return null;
	return buildRT(pre,0,pre.length-1,ino,0,ino.length-1);
}
static Node buildRT(int[] pre,int preStart,int preEnd,int[] ino,int inStart,int inEnd) {
	if(preStart>preEnd ||inStart>inEnd)
		  return null;
	int data = pre[preStart];
	Node node = new Node(data);
	int offset = inStart;
	for(int i=0;i<ino.length && offset<inEnd ;i++) {
		if(ino[i]==data) {
			offset = i;
			break;}
	}
	node.left = buildRT(pre,preStart+1,preStart-inStart+offset,ino,inStart,offset-1);
	node.right = buildRT(pre,preStart-inStart+offset+1,preEnd,ino,offset+1,inEnd);
	return node;
}
static Node constructInorderPostorder(int[] ino,int[] post) {
	if(post.length ==0 || post.length!=ino.length)
		return null;
	return build(post,0,post.length-1,ino,0,ino.length-1);
}
static Node build(int[] post,int postStart,int postEnd,int[] ino,int inStart,int inEnd) {
	if(postStart>postEnd ||inStart>inEnd)
		  return null;
	int data = post[postEnd];
	Node node = new Node(data);
	int offset = inStart;
	for(int i=0;i<ino.length && offset<inEnd ;i++) {
		if(ino[i]==data) {
			offset = i;
			break;}
	}
	node.left = build(post,postStart,postStart-inStart+offset-1,ino,inStart,offset-1);
	node.right = build(post,postStart-inStart+offset,postEnd-1,ino,offset+1,inEnd);
	return node;
}
static Node constructPreorderPostOrder(int[] pre,int[] post) {
	if(pre.length==0 || pre.length!=post.length)
		return null;
	return buildBT(pre,0,pre.length-1,post,0,post.length-1);
}
static Node buildBT(int[] pre,int preStart,int preEnd,int[] pos,int posStart,int posEnd) {
	if(preStart>preEnd || posStart>posEnd)
		return null;
	Node curr = new Node(pre[preStart]);
	if(preEnd-preStart==0)
		return curr;
	int data = pre[preStart+1];
	int offset = posStart;
	for(int i=0;offset<posEnd;i++) {
		if(data==pos[i]) {
			offset = i;
			break;
		}
	}
	offset++;
	curr.left = buildBT(pre,preStart+1,preStart-posStart+offset,pos,posStart,offset-1);
	curr.right = buildBT(pre,preStart-posStart+offset+1,preEnd,pos,offset,posEnd-1);
	return curr;
}

public static void main(String[] args) {
    int[] preOrder = {1,2,4,5,3,6};
    int[] inOrder = {4,2,5,1,6,3};
    int[] postOrder = {4,5,2,6,3,1};
    Node root = constructPreorderPostOrder(preOrder,postOrder);
    preorder(root);
    
}
}
