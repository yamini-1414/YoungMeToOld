package Sorting;

import java.awt.List;

public class QuickSortLL {
static class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}
Node getLast(Node head) {
	Node temp = head;
	while(temp.next!=null)
		temp = temp.next;
	return temp;
}
static class Res{
	Node newHead;
	Node newEnd;
}
Node quickSort(Node head,Node last) {
	if(head==null || head==last)
		return head;
	Res r  = new Res();
	Res s =  new Res();
	
	Node pivot = partition(head,last,r,s);
	if(r.newHead!=pivot) {
		Node tmp = r.newHead;
		while(tmp.next!=pivot)
			tmp= tmp.next;
		tmp.next=null;
		r.newHead = quickSort(r.newHead,tmp);
		tmp = getLast(r.newHead);
		tmp.next = pivot;
	}
	pivot.next = quickSort(pivot.next,s.newEnd);
	return r.newHead;
}

Node partition(Node head,Node last,Res r,Res s) {
	Node pivot = last;
	Node curr = head;
	Node tail =pivot;
	Node prev = null;
	
	while(curr!=pivot) {
		if(curr.data<pivot.data) {
			
			if(r.newHead==null)
				r.newHead = curr;
			prev = curr;
			curr = curr.next;
		}
		else {
		if(prev!=null)
			prev.next = curr.next;
		Node tmp = curr.next;
		curr.next = null;
		tail.next = curr;
		tail = curr;
		curr = tmp;
		}
	}
	if(r.newHead==null)
		r.newHead = pivot;
	s.newEnd=tail;
	return pivot;
}
public void traverse(Node head) {
	Node temp=head;
	while(temp!=null) {
		System.out.print(temp.data+" ");
		temp = temp.next;
	}
	
}
public Node sortList(Node head) {
	Node list2 = head.next;
	Node temp = head.next;
	while(temp!=null && temp.next!=null) {
		temp = temp.next.next;
        list2.next = temp;
      
	}
	return list2;
}
public static void main(String[] args) {
	QuickSortLL q = new QuickSortLL();
	Node head = new Node(13);
	head.next = new Node(99);
	head.next.next = new Node(21);
	head.next.next.next = new Node(80);
	head.next.next.next.next = new Node(50);
	//head.next.next.next.next.next = new Node(7);
	//Node h = q.quickSort(head, q.getLast(head));
	//System.out.println(h.data);
	Node h = q.sortList(head);
	q.traverse(h);
}
}
