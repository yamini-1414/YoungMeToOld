package LinkedList;

import java.util.Scanner;
import java.util.Stack;

public class ReorderList {
static class Node{
	int data;
	Node next;
	Node(int data){
		this.data  = data;
		this.next = null;
	}
}
public static Node reOrderList(Node head) {
	Node firstptr = head;
	Node secondptr = head;
	Stack<Node> s = new Stack<Node>();
	while(firstptr!=null && firstptr.next!=null) {
		firstptr = firstptr.next.next;
		secondptr = secondptr.next;
	}
	Node last = secondptr.next;
	secondptr.next = null;
	Node temp = last;
	while(temp!=null) {
		s.push(temp);
		temp = temp.next;
	}
	Node temp1 = head;
	while(!s.isEmpty() && temp1!=null) {
		Node curr = s.pop();
		curr.next = temp1.next;
		temp1.next = curr;
		temp1= temp1.next;
	}
	return head;
}
public static Node insert(Node head,int data) {
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
	Node temp= head;
	while(temp!=null) {
		System.out.print(temp.data+" ");
		temp = temp.next;
	}
}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		Node head = null;
		for(int i=0;i<n;i++)
			head = insert(head,sc.nextInt());
		head = reOrderList(head);
		printList(head);
		System.out.println();
	}
}
}
