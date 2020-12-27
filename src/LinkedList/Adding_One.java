package LinkedList;


public class Adding_One {
   static class Node{
	   int data;
	   Node next;
	   Node(int data){
		   this.data = data;
		   this.next = null;
	   }
   }
   public static Node addOneLast(Node head) {
	   Node rHead = reverseList(head);
	   Node curr = rHead;
	   while(curr!=null) {
		
		   if(curr.data<9) {
			   curr.data = curr.data+1;
			   break;
		   }else if(curr.data==9) {
			   curr.data = 0;
			   if(curr.next==null) {
				   Node newNode = new Node(1);
				   curr.next = newNode;
				   break;
			   }
		   }
		   curr = curr.next;
	   }
	   Node nHead = reverseList(rHead);
	   return nHead;
	   
   }
   public static  Node insert(Node head,int data) {
	   Node newNode = new Node(data);
	   if(head==null) {
		   head = newNode;
		   return head;
	   }
	   Node temp = head;
	   while(temp.next!=null)
		   temp = temp.next;
	   temp.next = newNode;
	   return head;
   }
   public static void printList(Node head) {
	   if(head==null)
		   return;
	   Node temp = head;
	   while(temp!=null) {
		   System.out.print(temp.data+" ");
		   temp = temp.next;
	   }
   }
	
	public static Node reverseList(Node head) {
		if(head==null || head.next==null)
			return head;
		Node prev = null;
		Node curr = head;
		while(curr!=null) {
			Node last = curr.next;
			curr.next = prev;
			prev = curr;
			curr = last;
		}
			return prev;
	}
	public static void main(String[] args) {
		Node head = null;
		head = insert(head,4);
		head = insert(head,8);
		head = insert(head,5);
		head = insert(head,9);
	    head = addOneLast(head);
	    printList(head);
	}

}
