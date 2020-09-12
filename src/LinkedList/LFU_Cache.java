package LinkedList;

public class LFU_Cache {
static class Node{
	int freq;
	int key;
	int value;
	Node prev;
	Node next;
	Node(int key,int val){
		this.key = key;
		this.value = val;
		this.prev = this.next = null;
	}
}
static class DNode{
     
}
}
