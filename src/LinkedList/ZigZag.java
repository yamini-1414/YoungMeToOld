package LinkedList;

public class ZigZag {
static class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}
public Node zigzag(Node head) {
     if(head==null || head.next==null)
    	 return head;
     Node curr = head;
     boolean flag = true;
     while(curr!=null && curr.next!=null) {
    	 if(flag) {
    		 if(curr.data >curr.next.data) {
    			 int temp = curr.data;
    			 curr.data = curr.next.data;
    			 curr.next.data = temp;
    		 }
    	 }else {
    		 if(curr.data<curr.next.data) {
    			 int temp = curr.data;
    			 curr.data = curr.next.data;
    			 curr.next.data = temp;
    		 }
    	 }
    	 flag = !flag;
    	 curr = curr.next;
     }
     return head;
}
}
