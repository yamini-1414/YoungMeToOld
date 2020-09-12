package LinkedList;

public class PairwiseSwap {
static class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}
public static Node pairSwap(Node head) {
	if(head==null || head.next==null)
		  return null;
	Node temp = head.next;
	head.next = temp.next;
	temp.next = head;
	head = temp;
	head.next.next = pairSwap(head.next.next);
	return head;	
}
}
