package LinkedList;

public class NthFromLast {
static class Node{
	int data;
	Node next;
	Node (int data){
		this.data = data;
		this.next = null;
	}
}
public Node nthLast(Node head,int n) {
	Node curr = head;
	Node prev = head;
	for(int i=0;i<n && curr!=null;i++)
		curr = curr.next;
	while(curr!=null) {
		prev = prev.next;
		curr = curr.next;
	}
	return prev;
}
}
