package LinkedList;

public class RemoveDuplicates {
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	public Node removeDuplicates(Node head) {
		Node curr = head;
		while(curr!=null) {
			Node temp = curr;
			while(temp.next!=null) {
				if(temp.next.data==curr.data)
					temp.next = temp.next.next;
				else
					temp= temp.next;
			}
			curr = curr.next;
		}
		return head;
	}
}
