package Arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MergingIntervals {
public static class Node{
	int start;
	int end;
	Node(int start,int end){
		this.start = start;
		this.end = end;
	}
}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
	int n = sc.nextInt();
	int[] arrival = new int[n];
	int[] dept = new int[n];
	Node[] nodes = new Node[n];
	for(int i=0;i<n;i++) 
		arrival[i] = sc.nextInt();
	for(int j=0;j<n;j++)
		dept[j] = sc.nextInt();
	
	for(int i=0;i<n;i++)
		nodes[i] = new Node(arrival[i],dept[i]);
	
	Arrays.sort(nodes, new Comparator<Node>(){
		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return o1.start-o2.start;
		}
	});
	int maxCount=0; int maxStart=0; int count=1;
	for(int i=0;i<arrival.length-1;i++) {
		count = 1; 
		for(int j=i+1;j<arrival.length;j++) {
			if(nodes[i].end>=nodes[j].start)
				count++;
			//System.out.println(count);
			if(count>maxCount) {
				maxCount = count;
				maxStart = nodes[j].start;
			}
		}
	}
	System.out.println(maxCount+" "+maxStart);
	}
}
}
