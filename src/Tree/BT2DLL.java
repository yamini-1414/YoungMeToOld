package Tree;
public class BT2DLL {
static class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
		this.left= this .right= null;
	}
}
static Node head=null;
static void convertDLL(Node root) {
	if(root!=null) {
		convertDLL(root.left);
		Node new_node = new Node(root.data);
		if(head==null)
			head = new_node;
		else {
			Node temp = head;
			while(temp.right!=null)
				temp = temp.right;
			temp.right = new_node;
			new_node.left = temp;
		}
		convertDLL(root.right);
	}
}
static void printList() {
	Node prev = null;
	Node temp = head;
	while(temp!=null) {
		System.out.print(temp.data+" ");
	    prev = temp;
	    temp = temp.right;
	}
	System.out.println();
	while(prev!=null) {
		System.out.print(prev.data+" ");
		prev = prev.left;
	}
}

public static void main(String[] args) {
	Node root = new Node(10);
	root.left = new Node(12);
	root.right = new Node(15);
	root.left.left = new Node(25);
	root.left.right = new Node(30);
	root.right.left = new Node(36);
	convertDLL(root);
	printList();
}
}
