package Graph;
import java.util.ArrayList;
import java.util.Scanner;

public class CycleUnionSet {
        static class Node{
        	int start;
        	int end;
        	Node(int start,int end){
        		this.start = start;
        		this.end = end;
        	}
        }
        static Node[][] nodes;
        public static void main(String[] args) {
        	Scanner sc  = new Scanner(System.in);
        	int T = sc.nextInt();
        	for(int t=0;t<T;t++) {
        		
        	}
        	
        }
        public static int find(int[] parent,int i) {
        	if(parent[i]==-1)
        		return i;
        	else 
        		return find(parent,parent[i]);
        }
        public static void union(int[] parent,int x,int y) {
        	int rootX = find(parent,x);
        	int rootY = find(parent,y);
        	if(rootX!=rootY)
        		parent[rootX] = rootY;
       }
        static boolean isCycle(ArrayList<ArrayList<Integer>> list,int v){
        	int[] parent = new int[v];
        	for(int i=0;i<v;i++)
        		parent[i]=-1;
           	ArrayList<Integer> arr = new ArrayList<Integer>();
           	for(int i=0;i<list.size();i++) {
           		arr = list.get(i);
           		for(int j=0;j<arr.size();j++) {
           			int start = i;
           			int end = arr.get(j);
           			int X = find(parent,start);
           			int Y = find(parent,end);
           			if(X==Y)
           				return true;
           			else
           				union(parent,X,Y);
           		}
           	}
           	return false;
        }
        
        	
        
        
}
