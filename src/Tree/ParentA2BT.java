package Tree;

import java.util.ArrayList;

public class ParentA2BT {
static class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
		this.left = this.right = null;
	}
}
static Node root;
public static Node constructUtil(int[] arr,int n) {
    if(n==0)
    	return null;
    Node[] nodes = new Node[n];
    int root=0;
    for(int i=0;i<n;i++) {
    	nodes[i] = new Node(i);
    	if(arr[i]==-1) 
    		root = i;
    }
    
    for(int i=0;i<n;i++) {
    	if(arr[i]!=-1) {
    		if(nodes[arr[i]].left==null)
    			nodes[arr[i]].left=nodes[i];
    		else if(nodes[arr[i]].right==null)
    			nodes[arr[i]].right= nodes[i];
    	}
    }
    return nodes[root];
}
}
