package LinkedList;


public class MiddleLinkedList {
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	public Node getMiddle(Node head) {
		Node first = head; 
		Node second = head;
		Node prev= null;
		while(first!=null && first.next!=null) {
			first = first.next.next;
			prev = second;
			second = second.next;
		}
		prev.next = second.next;
		return head;
	}
}
