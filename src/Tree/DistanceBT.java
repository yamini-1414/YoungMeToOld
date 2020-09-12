package Tree;

public class DistanceBT {
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
			this.left= this.right= null;
		}
	}
	static int dist;
	static int findDistanceRoot(Node root,int x) {
		if(root==null)
			return -1;
		dist = -1;
		if((root.data==x)|| findDistanceRoot(root.left,x)>=0 ||
				findDistanceRoot(root.right,x)>=0) 
			dist++;
			
		return dist;
	}
    static Node findLCA(Node root,int n1,int n2) {
    	if(root==null)
    		return null;
    	if(root.data==n1 || root.data==n2)
    		return root;
    	Node left_lca = findLCA(root.left,n1,n2);
    	Node right_lca = findLCA(root.right,n1,n2);
    	if(left_lca!=null && right_lca!=null)
    		return root;
    	return left_lca!=null ?left_lca:right_lca;
    }
    static int distNodes(Node root,int n1,int n2) {
    	if(root==null)
    		  return 0;
    	Node lca = findLCA(root,n1,n2);
    	return findDistanceRoot(root,n1)+findDistanceRoot(root,n2)
    	        - (2*findDistanceRoot(root,lca.data));
    }
	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(1);
		root.right = new Node(3);
		root.right.left = new Node(5);
		//System.out.println(findDistanceRoot(root,5));
		//System.out.println(findLCA(root,1,5).data);
		System.out.println(distNodes(root,1,5));
	}
}
