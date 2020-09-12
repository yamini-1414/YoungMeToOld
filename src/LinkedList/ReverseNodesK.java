package LinkedList;

public class ReverseNodesK {
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
			this.next = null;
		}
	}
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr= head;
        ListNode prev = null;
        ListNode last = null;
        //Done with the first k elements
        while(curr!=null && k>0) {
        	last = curr.next;
        	curr.next = prev;
        	prev = curr;
        	curr = last;
        	k--;
        }
        if(last!=null)
        	head.next = reverseKGroup(last,k);
        return prev;
    }
}
