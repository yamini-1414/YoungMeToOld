package PriorityQueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SortedMatrix {
	
	static class HNode{
		int data;
		int x;
		int y;
		HNode(int data,int x,int y){
			this.data = data;
			this.x= x;
			this.y = y;
		}
	}
	static class MinHeap{
		HNode[] nodes;
		int size;
		int capacity;
		MinHeap(int capacity){
			this.nodes = new HNode[capacity];
			this.capacity = capacity;
			this.size=0;
		}
		public int left(int i) {
			return 2*i+1;
		}
		public int right(int i) {
			return 2*i+2;
		}
		public int parent(int i) {
			return (i-1)/2;
		}
		public void insert(HNode node) {
			if(size==capacity)
				return;
			size++;
			int i = size-1;
			nodes[i] = node;
			while(i!=0 && nodes[i].data<nodes[parent(i)].data) {
			   HNode temp = nodes[i];
			   nodes[i] = nodes[parent(i)];
			   nodes[parent(i)] = temp;
			   i = parent(i);
			}
		}
		public HNode getMin() {
			if(size<=0)
				return null;
			return nodes[0];
		}
		public void MinHeapify(int i) {
			int smallest = i;
			int left = left(i);
			int right = right(i);
			if(left<size && nodes[smallest].data>nodes[left].data)
				smallest = left;
			if(right<size && nodes[smallest].data>nodes[right].data)
				smallest = right;
			if(smallest!=i) {
				HNode temp = nodes[i];
				nodes[i] = nodes[smallest];
				nodes[smallest] = temp;
				//System.out.println(nodes[smallest].data+" "+nodes[i].data);
				MinHeapify(smallest);
			}
		}
		public void replaceMin(HNode root) {
			nodes[0] = root;
			MinHeapify(0);
		}
	}
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		int[][] matrix = new int[n][n];
		for(int i=0;i<n;i++) 
			for(int j=0;j<n;j++)
				matrix[i][j] = sc.nextInt();
		sortMatrix(matrix,n);
		System.out.println();
	}
}
static void sortMatrix(int[][] matrix,int n) {
	MinHeap h = new MinHeap(n);
	for(int i=0;i<matrix.length;i++)
		h.insert(new HNode(matrix[i][0],i,1));
	for(int i=0;i<n*n;i++) {
		HNode root = h.getMin();
		System.out.print(root.data+" ");
		if(root.y<n)
			root.data = matrix[root.x][root.y++];
		else
			root.data = Integer.MAX_VALUE;
		h.insert(root);
	}
}
}
