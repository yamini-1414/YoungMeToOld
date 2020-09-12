package LinkedList;

public class AddLL {
static class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}
public Node addList(Node l1,Node l2) {
	Node head  = new Node(-1);
	Node curr = head;
	int carry=0;
	while(l1!=null || l2!=null) {
		
	 int a = l1!=null?l1.data:0;
	 int b = l2!=null?l2.data:0;
	 int sum = a+b+carry;
	 carry = sum/10;
	 curr.next = new Node(sum%10);
	 
	 if(l1!=null) l1 = l1.next;
	 if(l2!=null) l2 = l2.next;
	 curr = curr.next;
	}
	if(carry!=0) {
		curr.next = new Node(carry);
		curr = curr.next;
	}
	return head.next;
}
}
