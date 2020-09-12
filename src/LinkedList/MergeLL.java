package LinkedList;

public class MergeLL {
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	public Node mergeLLIter(Node head1,Node head2) {
		Node head = new Node(-1);
		Node curr = head.next;
		while(head1!=null && head2!=null) {
			if(head1.data<=head2.data) {
				curr.next = head1;
				head1 = head1.next;
		}else {
			curr.next = head2;
			head2 = head2.next;
		}
	}
		if(head1!=null)
			curr.next = head1;
		else if(head2!=null)
			curr.next = head2;
		return head.next;
}
	public Node mergeLLRec(Node head1,Node head2) {
		if(head1==null)
			return head2;
		if(head2==null)
			return head1;
		Node head = new Node(0);
		if(head1.data<=head2.data) {
			head = head1;
			head.next = mergeLLRec(head1.next,head2);
		}else {
			head= head2;
			head.next = mergeLLRec(head2.next,head1);
		}
		return head;
	}
}