package LinkedList;

public class OddEven {
	static class ListNode{
		int data;
		ListNode next;
		ListNode(int data){
			this.data = data;
			this.next = null;
		}
	}
	 public ListNode oddEvenList(ListNode head) {
	        if(head==null || head.next==null) return head;
	        ListNode curr = head;
	        ListNode temp = head;
	        for(int i=0;temp.next!=null;i++){
	            if(i%2!=0){
	                ListNode even = temp.next;
	                temp.next = temp.next.next;
	                even.next = curr.next;
	                curr.next = even;
	                curr = curr.next;
	            }else
	                temp = temp.next;
	        }
	        return head;
	    }
}
