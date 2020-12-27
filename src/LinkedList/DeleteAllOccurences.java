package LinkedList;

public class DeleteAllOccurences {
static class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}
public Node delete(Node head,int x) {
	if(head==null)
		return head;
	
	while(head!=null && head.data==x)
		head = head.next;
	if(head==null)
		return null;
	Node temp = head;
	while(temp!=null && temp.next!=null) {
		if(temp.next.data==x)
			temp.next = temp.next.next;
		temp = temp.next;
	}
	return head;
}
}
