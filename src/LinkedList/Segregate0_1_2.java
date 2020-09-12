package LinkedList;

public class Segregate0_1_2 {
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	Node segregate(Node head) {
		int cnt1=0;
		int cnt2=0;
		int cnt3=0;
		
		Node temp = head;
		while(temp!=null) {
			switch(temp.data) {
			case 0: 
				   cnt1++;
				   break;
			case 1:
				   cnt2++;
				   break;
			case 2:
				  cnt3++;
				  break;
			}
			temp = temp.next;
		}
		Node newHead = new Node(-1);
		Node curr = newHead;
		while(cnt1>0) {
			curr.next = new Node(0);
			curr = curr.next;
			cnt1--;
		}
		while(cnt2>0) {
			curr.next = new Node(1);
			curr = curr.next;
			cnt2--;
		}
		while(cnt3>0) {
			curr.next = new Node(2);
			curr = curr.next;
			cnt3--;
		}
		return newHead.next;
	}
}
