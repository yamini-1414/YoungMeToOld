package LinkedList;

public class ReverseList {
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
public static Node reverseList(Node head) {
	if(head==null || head.next==null)
		return head;
	Node prev = null;
	Node curr = head;
	while(curr!=null) {
		Node last = curr.next;
		curr.next = prev;
		prev = curr;
		curr.next = last;
	}
		return prev;
}
}
