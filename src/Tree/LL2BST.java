package Tree;
public class LL2BST {
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
			this.left = this.right = null;
		}
	}
static class LNode{
	int data;
	LNode next;
	LNode(int data){
		this.data = data;
		this.next = null;
	}
}
static LNode head;
public static LNode add(int key) {
	LNode new_node = new LNode(key);
	   if(head==null) {
		   head = new_node;
		   return head;
	   }
	   LNode temp = head;
	   while(temp.next!=null)
		   temp = temp.next;
	   temp.next = new_node;
	   return head;
}
public static int length() {
	if(head==null)
		 return 0;
     int cnt=0;
     LNode temp = head;
     while(temp!=null) {
    	 cnt++;
    	 temp = temp.next;
     }
     return cnt;
}
public static Node convertLL2BST(int start,int end) {
	if(start>end)
		return null;
	int mid = (start+end)/2;
	Node left = convertLL2BST(start,mid-1);
    Node root = new Node(head.data);
    root.left = left;
    if(head.next!=null)
    	head = head.next;
    root.right = convertLL2BST(mid+1,end);
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
	int[] arr = {2,3,4,5,6,7,8};
	for(int i=0;i<arr.length;i++)
		head = add(arr[i]);
    Node root1 = convertLL2BST(0,length()-1);
    inorder(root1);
}
} 