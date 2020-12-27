package LinkedList;

public class FlattenList {
static class Node{
	int data;
	Node next;
	Node bottom;
	Node(int data){
		this.data  = data;
		this.next = this.bottom = null;
	}
}
public Node insert(Node head,int key) {
	Node newNode = new Node(key);
	if(head==null || key<=head.data) {
		newNode.bottom = head;
		head = newNode;
		return head;
	}
	Node temp = head;
	while(temp.bottom!=null && key>temp.bottom.data) 
		temp  = temp.bottom;
	newNode.bottom = temp.bottom;
	temp.next = newNode;
	return head;
}
public Node flatten(Node root) {
	if(root==null)
		return root;
	Node temp = root;
	Node newHead = null;
	while(temp!=null) {
		Node temp1 = temp;
		while(temp1!=null) {
			newHead = insert(newHead,temp1.data);
			temp1 = temp1.bottom;
		}
		temp = temp.next;
	}
	return newHead;
}
}
