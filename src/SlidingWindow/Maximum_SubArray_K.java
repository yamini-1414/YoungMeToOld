package SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Maximum_SubArray_K {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
	   maxSubArrayK(arr,k);	
	}
}
public static void maxSubArrayK(int[] arr,int k) {
	Deque<Integer> q = new LinkedList<Integer>();
	
	for(int i=0;i<k;i++) {
		while(!q.isEmpty() && arr[i]>=arr[q.peekLast()])
			q.removeLast();
		q.addLast(i);
	}
	for(int i=k;i<arr.length;i++) {
		System.out.print(arr[q.peekFirst()]+" ");
		
		while(!q.isEmpty() && q.peek()<=(i-k))
			q.removeFirst();
		
		while(!q.isEmpty() && arr[i]>=arr[q.peekLast()])
			q.removeLast();
		q.addLast(i);
	}
	System.out.print(arr[q.peekFirst()]+" ");
}
}