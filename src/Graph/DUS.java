package Graph;

import java.util.HashSet;
import java.util.Set;

public class DUS {
int[] parent;
int[] rank;
DUS(int size){
	parent = new int[size];
	for(int i=0;i<size;i++)
		parent[i] = i;
	rank = new int[size];
}
public int find(int x) {
	if(parent[x]!=x) {
		parent[x] = find(parent[x]);
	}
	return parent[x];
}
public boolean union(int x,int y) {
	if(find(x)==find(y)) return false;
	int px = find(x); int py = find(y);
	if(rank[px]<rank[py])
		parent[px]= py;
	else if(rank[px]>rank[py])
		parent[py]= px;
	else {
		rank[px]++;
		parent[py] = px;
	}		return true;
}
public boolean sunion(int x,int y) {
	if(find(x)==find(y)) return false;
	int px = find(x); int py = find(y);
	System.out.println(px+" "+py);
	parent[px]= py;
	return true;
}
public static void main(String[] args) {
	DUS dus = new DUS(20000);
	int[][] stones = {{0,0},{0,2},{1,1},{2,0},{2,2}};
	for(int[] stone:stones)
		dus.union(stone[0], 10000+stone[1]);
	Set<Integer> set = new HashSet<Integer>();
	for(int[] stone:stones)
		set.add(dus.find(stone[0])); //gives the no of connected components
}
}
