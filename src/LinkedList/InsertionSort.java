  package LinkedList;

public class InsertionSort {
static class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}
public static Node insertionSort(Node newHead,Node newNode) {
	if(newHead==null || newNode.data<= newHead.data) {
		newNode.next = newHead;
		newHead = newNode;
		return newHead;
	}else {
	Node temp = newHead;
	while(temp.next!=null && newNode.data>temp.next.data)
		temp = temp.next;
	newNode.next = temp.next;
	temp.next = newNode;	
	}
	return newHead;
}
public static Node insert(int data,Node head) {
	Node new_node = new Node(data);
	if(head==null) {
	    head = new_node;
	    return head;
	}
	Node temp = head;
	while(temp.next!=null)
		temp= temp.next;
	temp.next = new_node;
	return head;	
}
public static void printList(Node head) {
	Node temp = head;
	while(temp!=null) {
		System.out.print(temp.data+" ");
		temp = temp.next;
	}
}
public static void main(String[] args) {
	Node head = null;
	int[] arr = {1,-2,-3,4,-5};
	for(int i=0;i<arr.length;i++)
		head = insertionSort(head,new Node(arr[i]));
	printList(head);
}
}
