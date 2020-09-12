package Tree;
public class DeletionInBT {
static class Node{
	int data;
    Node left;
    Node right;
    Node(int data){
    	this.data = data;
    	this.left = this.right = null;
    }
}
     public static Node deleteHalfNodes(Node root) {
    	 if(root==null) return null;
    	 root.left = deleteHalfNodes(root.left);
    	 root.right = deleteHalfNodes(root.right);
    	 if(root.left==null && root.right!=null)
    		 return root.right;
    	 if(root.left!=null && root.right==null)
    		 return root.left;
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
    	 Node root = new Node(2);
    	 root.left = new Node(7);
    	 root.right = new Node(5);
    	 root.left.right = new Node(6);
    	 root.left.right.left = new Node(1);
    	 root.left.right.right = new Node(11);
    	 root.right.right = new Node(9);
    	 root.right.right.left = new Node(4);
    	 root = deleteHalfNodes(root);
    	 inorder(root);
    			 
     }
}
