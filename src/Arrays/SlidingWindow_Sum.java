package Arrays;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SlidingWindow_Sum {
public static void getMin(int[] arr,int w) {
	Deque<Integer> q = new LinkedList<Integer>();
	for(int i=0;i<w;i++) {
		while(!q.isEmpty() && arr[i]<=q.getLast())
			q.pollLast();
		q.offerLast(i);
	}
	for(int i = w;i<arr.length;i++) {
		int x = arr[q.pollFirst()];
		System.out.print(x<0?x:0+" ");
		while(!q.isEmpty() && q.peekFirst()<=(i-w))
			q.pollFirst();
		while(!q.isEmpty() && arr[i]<=q.getLast())
			q.pollLast();
		q.offerLast(i);
	}
	int x = arr[q.pollFirst()];
	System.out.print(x<0?x:0+" ");
}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++)
			a[i] =  sc.nextInt();
		int w = sc.nextInt();
		getMin(a,w);
		System.out.println();
	}
}
}
