package Tree;
public class AVLTree {
static class AVLNode{
	int data;
	int height;
	AVLNode left;
	AVLNode right;
	AVLNode(int data){
		this.data = data;
		this.height = 0;
		this.left = this.right = null;
	}
}
public AVLNode singleRotateRight(AVLNode X ) {
	if(X==null)
		 return null;
	AVLNode W = X.left;
	X.left = W.right;
	W.right = X;
	X.height = Math.max(height(X.left), height(X.right))+1;
	W.height = Math.max(height(W.left), height(X))+1;
	return W;
}
public AVLNode singleRotateLeft(AVLNode X) {
	if(X==null)
		return null;
	AVLNode W = X.right;
	X.right = W.left;
	W.left = X;
	X.height = Math.max(height(X.left), height(X.right))+1;
	W.height = Math.max(height(W.right), height(X))+1;
	return W;
}
public AVLNode LRRotate(AVLNode X) {
	if(X==null)
		return null;  
	X.left = singleRotateLeft(X.left);
	return singleRotateRight(X);
}
public AVLNode RLRotate(AVLNode X) {
	if(X==null)
		return null;
	X.right = singleRotateRight(X.right);
	return singleRotateLeft(X);
}
public int getBalance(AVLNode root) {
	return height(root.left)- height(root.right);
}
public AVLNode insert(AVLNode root,int data) {
	if(root==null) {
		return new AVLNode(data);
	}
	if(data<root.data)
		root.left = insert(root.left,data);
	else if(data>root.data)
		root.right = insert(root.right,data);
	
	root.height = Math.max(height(root.left), height(root.right))+1;
	
	int balance = getBalance(root);
	if(balance> 1 && data<root.left.data) {
		return singleRotateRight(root);
	}
	if(balance>1 && data>root.left.data) {
		return LRRotate(root);
	}
	if(balance<1 && data>root.right.data) {
		return singleRotateLeft(root);
	}
	if(balance<1 && data<root.right.data) {
		return RLRotate(root);
	}
	return root;
}
public AVLNode delete(AVLNode root, int key) {
	if(root==null)
		return root;
	if(key<root.data)
		root.left = delete(root.left,key);
	else if(key> root.data)
		root.right = delete(root.right,key);
	else {
		if(root.left!=null && root.right!=null) {
			root.data = getMin(root.right);
			root.right = delete(root.right,root.data);
		}else if(root.left==null)
			return root.right;
		else if(root.right==null)
			return root.left;
	}
	return root;
}
public int height(AVLNode root) {
	if(root==null)
		return 0;
	int left = height(root.left);
	int right = height(root.right);
	return left>right?left+1:right+1;
}
public int getMin(AVLNode root) {
	while(root.left!=null)
		root = root.left;
	return root.data;
}
}
