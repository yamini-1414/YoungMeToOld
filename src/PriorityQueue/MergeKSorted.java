package PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
public class MergeKSorted {
	static class Node{
		int data;
		int x;
		int y;
		Node(int data,int x,int y){
			this.data = data;
			this.x = x;
			this.y = y;
		}
	}
	static void sort(int[][] matrix,int n) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
			public int compare(Node a,Node b) {
				return a.data-b.data;
			}
		});
		for(int i=0;i<n;i++) 
			pq.add(new Node(matrix[i][0],i,1));
		
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			System.out.print(temp.data+" ");
			if(temp.y<n)
				pq.add(new Node(matrix[temp.x][temp.y++],temp.x,temp.y));
		}
	}
	public static void main(String[] args) {Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		int[][] matrix = new int[n][n];
		for(int i=0;i<n;i++) 
			for(int j=0;j<n;j++)
				matrix[i][j] = sc.nextInt();
		sort(matrix,n);
		System.out.println();
	}
}
}
