package LinkedList;

public class SubtractLL {
  static class Node{
	  int data;
	  Node next;
  Node(int data){
	  this.data = data;
	  this.next = null;
  }
  }
  static boolean borrow;
  public Node subtractList(Node head1, Node head2) {
	  if(head1==null || head2==null)
		  return null;
	  Node previous = subtractList(head1!=null?head1.next:null,head2!=null?head2.next:null);
	  
	  int  d1 = head1.data;
	  int d2  = head2.data;
	  if(borrow) {
		  d1--;
		  borrow= false;
	  }
	  if(d1<d2) {
		  borrow = true;
		  d1 = d1+10;
	  }
	  Node sub = new Node(d1-d2);
	  sub.next = previous;
	  return sub;
  }
  public Node subtractListHelper(Node head1, Node head2) {
	  if(head1==null && head2==null)
		  return null;
	  int len1 = getLen(head1);
	  int len2 = getLen(head2);
	  
	  Node fNode = null; Node sNode = null;
	  if(len1!=len2) {
		  fNode = len1>len2?head1:head2;
		  sNode = len1>len2?head2:head1;
		  sNode = patchZeroes(sNode,Math.abs(len1-len2));
	  }else {
	  Node temp1 = head1; Node temp2=head2;
	  while(head1!=null && head2!=null) {
		  if(head1.data!=head2.data) {
		  fNode = head1.data>head2.data?temp1:temp2;
		  sNode = head1.data>head2.data?temp2:temp1;
		  break;
		  }
		  head1 = head1.next;
		  head2 = head2.next;
	  }
	  }
	  borrow=false;
	  return subtractList(fNode,sNode);
  }
  public Node patchZeroes(Node head, int k) {
	  
	  while(k>0) {
		  Node newNode = new Node(0);
		  newNode.next = head;
		  head = newNode;
		  k--;
	  }
	  return head;
  }
  public int getLen(Node head) {
	  int cnt=0;
	  Node temp = head;
	  while(temp!=null) {
		  cnt++;
		  temp = temp.next;
	  }
	  return cnt;
  }
}
