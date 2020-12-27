package LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class CountPairsinLL {
static class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}
public static int findPairs(LinkedList<Integer> head1,LinkedList<Integer> head2,int X) {
	ArrayList<Integer> arr = new ArrayList<Integer>();
    head1.forEach(temp-> arr.add(temp));
    int count=0;
    for(Integer temp: head2) {
    	if(arr.contains(X-temp))
    		count++;
    }
    return count;
}
}
