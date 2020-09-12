 package LinkedList;

import java.util.Stack;

public class PalindromeList {
	static class ListNode{
		int data;
		ListNode next;
		ListNode(int data){
			this.data = data;
			this.next = null;
		}
	}
	static boolean isPalindrome(ListNode head) {
		Stack<Integer> s = new Stack<Integer>();
	    ListNode temp = head;
	    while(temp!=null) {
	    	s.push(temp.data);
	    	temp = temp.next;
	    }
	    ListNode curr = head;
	    while(curr!=null) {
	    	if(s.pop()!=curr.data)
	    		  return false;
	    	curr = curr.next;
	    }
	    return true;
	}
	 public boolean isPalindromeS(ListNode head) {
	        if(head==null) return true;
	        ListNode middle = middleList(head);
	        ListNode head1 = head;
	        ListNode rHead = reverseList(middle);
	        while(head1!=null && rHead!=null){
	            if(head1.data!=rHead.data) return false;
	            head1 = head1.next;
	            rHead = rHead.next;
	        }
	        return true;
	    }
	    public ListNode middleList(ListNode head){
	        ListNode fastptr = head;
	        ListNode slowptr = head;
	        while(fastptr!=null && fastptr.next!=null){
	            fastptr = fastptr.next.next;
	            slowptr = slowptr.next;
	        }
	        return slowptr;
	    }
	    public ListNode reverseList(ListNode head){
	        ListNode curr = head;
	        ListNode prev = null;
	        while(curr!=null){
	            ListNode last = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr = last;
	        }
	        return prev;
	    }
}
