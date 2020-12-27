package LinkedList;

public class ReverseSubList {
static class ListNode{
	int data;
	ListNode next;
	ListNode(int data){
		this.data = data;
		this.next = null;
	}
}
public  static ListNode insert(ListNode head,int data) {
	ListNode new_node = new ListNode(data);
	if(head==null) {
		head = new_node;
		return head;
	}
	ListNode temp = head;
	while(temp.next!=null)
		temp = temp.next;
	temp.next =new_node;
	return head;
}
public static ListNode reverseSubList(ListNode head,int m,int n) {
	if(m==n)
		 return head;
	ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode prev = dummy;
    for(int i=0;i<m-1;i++)
    	prev = prev.next;
    ListNode reverseHead = prev;
    prev = prev.next;
    ListNode curr = prev.next;
    for(int i=m;i<n;i++) {
    	prev.next = curr.next;
    	curr.next = reverseHead.next;
    	reverseHead.next = curr;
    	curr = prev.next;
    }
    return dummy.next;
}
public static void printList(ListNode head) {
     if(head==null) return;
     ListNode temp = head;
     while(temp!=null) {
    	 System.out.print(temp.data+" ");
    	 temp = temp.next;
     }
}
public static void main(String[] args) {
	ListNode head= null;
	for(int i=1;i<=6;i++)
		head = insert(head,i);
	printList(reverseSubList(head,3,5));
}
}
