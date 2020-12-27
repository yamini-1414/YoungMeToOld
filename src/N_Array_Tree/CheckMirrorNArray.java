package N_Array_Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class CheckMirrorNArray {
static class Node{
	int data;
	ArrayList<Node> child;
	Node(int data){
		this.data = data;
		child = new ArrayList<Node>();
	}
}
static Stack<Node> s;
static Queue<Node> q;
static int checkMirror(Node node1,Node node2) {
	if(node1==null || node2==null)
		 return 0;
	s = new Stack<Node>();
	q = new LinkedList<Node>();
	pushStack(node1);
	pushQueue(node2);
    while(!s.isEmpty() && !q.isEmpty()) {
    	if(s.pop().data!=q.poll().data)
    		return 0;
    }
	return 1;
}
static void pushStack(Node node) {
	if(node==null)
		  return;
	s.push(node);
	for(int i=0;i<node.child.size();i++)
		pushStack(node.child.get(i));
}
static void pushQueue(Node node) {
	if(node==null) return;
	for(int i=0;i<node.child.size();i++)
		pushQueue(node.child.get(i));
	q.offer(node);
}
static Node root1=null;
static Node root2 = null;
public static void main(String[] args) {
	Scanner sc  = new Scanner(System.in);
	int T = sc.nextInt();
	HashMap<Integer,Node> map1 = new HashMap<Integer,Node>();
	HashMap<Integer,Node> map2 = new HashMap<Integer,Node>();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		int e = sc.nextInt();
		for(int j=0;j<e;j++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			Node parent = map1.get(n1);
			if(parent==null) {
				parent = new Node(n1);
				map1.put(n1,parent);
				if(root1==null)
					  root1 = parent;
			}
			Node child = new Node(n2);
			parent.child.add(child);
			map1.put(n2, child);
		}
		for(int j=0;j<e;j++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			Node parent = map2.get(n1);
			if(parent==null) {
				parent = new Node(n1);
				map2.put(n1,parent);
				if(root2==null)
					  root2 = parent;
			}
			Node child = new Node(n2);
			parent.child.add(child); 
			map2.put(n2, child);
		}
		System.out.println(checkMirror(root1,root2));
	}
}
}
