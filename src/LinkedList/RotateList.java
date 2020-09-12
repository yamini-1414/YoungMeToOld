package LinkedList;

public class RotateList {
static class Node{
	int data;
	Node next;
}
public Node rotateList(int k, Node head) {
	k=k%getLen(head);
	if(head==null || head.next==null || k==0)
		return head;
	Node firstptr = head;
	Node secondptr = head;
	while(k>0) {
		firstptr = firstptr.next;
		if(firstptr==null)
			return head;
		k--;
	}
	if(firstptr==secondptr)
		return head;
	while(firstptr.next!=null) {
		firstptr = firstptr.next;
		secondptr = secondptr.next;
	}
	Node temp = secondptr.next;
	secondptr.next = null;
	firstptr.next = head;
	return temp;
	
}
public int getLen(Node head) {
	Node temp = head; int cnt=0;
	while(temp!=null) {
		cnt++;
		temp = temp.next;
	}
	return cnt;
}
}
