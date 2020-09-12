package LinkedList;

import java.util.ArrayList;

public class IntersectionLL {
static class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}
public Node intersectionLL(Node head1,Node head2) {
	if(head1==null || (head1==null && head2==null))
		return head2;
	if(head2==null)
		return head1;
	int len1 = getLen(head1);
	int len2 = getLen(head2);
	Node fNode = null; Node sNode= null;
	if(len1!=len2) {
		fNode = len1>len2?head1:head2;
		sNode = len1>len2?head2:head1;
	}
	Node temp1 = sNode;
	ArrayList<Integer> arr = new ArrayList<Integer>();
	while(temp1!=null) {
		arr.add(temp1.data);
		temp1 = temp1.next;
	}
	
	Node temp2 = fNode;
	Node head = new Node(-1);
	Node curr = head;
	
	while(temp2!=null) {
		if(arr.contains(temp2.data)) {
			curr.next = new Node(temp2.data);
			curr = curr.next;
		}
		temp2 = temp2.next;
	}
	return head.next;
}
public int getLen(Node head) {
	if(head==null)
		return 0;
	Node temp = head; int cnt=0;
	while(temp!=null) {
		cnt++;
		temp = temp.next;
	}
	return cnt;
}
}
