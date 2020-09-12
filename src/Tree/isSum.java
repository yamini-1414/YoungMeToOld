package Tree;

public class isSum {
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
			this.left= this.right= null;
		}
	}
	public static void main(String[] args) {
		 Node root = new Node(4);
		 root.left = new Node(1);
		 root.right = new Node(3);
		 root.right.left = new Node(5);
		 System.out.println(issum(root));
	}
	static boolean isBalanced(Node root)
    {
	  if(root==null) return true;
	  return (Math.abs(height(root.left)-height(root.right)))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }
    static int height(Node root){
        if(root==null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        return lh>rh?lh+1:rh+1;
    }
	public static boolean issum(Node root) {
		if(root.left==null && root.right==null || root==null)
			return true;
		int left = root.left==null ? 0:root.left.data;
		int right = root.right==null?0:root.right.data;
		return ((left+right)==root.data) &&issum(root.left)
				&& issum(root.right);
		
	}
}
