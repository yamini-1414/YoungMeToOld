 package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class IterativeTraversals {
static class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
		this.left= this.right= null;
	}
}
public static void main(String[] args) {
	 Node root = new Node(1);
	 root.left = new Node(2);
	 root.right = new Node(3);
	 root.left.left = new Node(4);
	 root.left.right = new Node(5);
	 root.right.left = new Node(6);
	 root.right.right = new Node(7);
	 //iterativePreOrder(root);
	 //iterativeInOrder(root);
	 //iterativePostOrder(root);
	 //levelOrderTraversal(root);
	 //verticalOrder(root);
	 zigZagOrder(root);
}
static TreeMap<Integer,ArrayList<Integer>> map;
public static void verticalOrder(Node root) {
	map = new TreeMap<Integer,ArrayList<Integer>>();
	verticalOrderBuild(root,0);
	List<Integer> arr = new ArrayList<Integer>();
	for(Integer key : map.keySet())
		arr.add(key);
	Collections.sort(arr);
	for(Integer key:arr) {
		map.get(key).forEach(temp-> System.out.print(temp+" "));
	}
}
public static void zigZagOrder(Node root) {
	if(root==null)
		return;
	Stack<Node> s1 = new Stack<Node>();
	Stack<Node> s2 = new Stack<Node>();
	s1.push(root);
	while(!s1.isEmpty() || !s2.isEmpty()) {
		while(!s1.isEmpty()) {
			Node temp =s1.pop();
			System.out.print(temp.data+" ");
			if(temp.left!=null)
				s2.push(temp.left);
			if(temp.right!=null)
				s2.push(temp.right);
		}
		while(!s2.isEmpty()) {
			Node temp = s2.pop();
			System.out.print(temp.data+" ");
			if(temp.right!=null)
				s1.push(temp.right);
			if(temp.left!=null)
				s1.push(temp.left);
		}
	}
}
public static void verticalOrderBuild(Node root,int hs) {

	if(root!=null) {
       ArrayList<Integer> arr = map.get(hs);
       if(arr==null)
    	   arr = new ArrayList<Integer>();
       arr.add(root.data);
       map.put(hs,arr);
        verticalOrderBuild(root.left,hs-1);
        verticalOrderBuild(root.right,hs+1);
	}
}
public static void levelOrderTraversal(Node root) {
	if(root==null)
		return;
	Queue<Node> q = new LinkedList<Node>();
	q.offer(root);
	q.offer(null);
	while(!q.isEmpty()) {
		Node temp = q.poll();
		if(temp!=null) {
			System.out.print(temp.data+" ");
			if(temp.left!=null)
				q.offer(temp.left);
			if(temp.right!=null)
				q.offer(temp.right);
		}else {
			if(!q.isEmpty())
				q.offer(null);
			System.out.println();
		}
	}
}
public static void  iterativeInOrder(Node root) {
	if(root==null)
		return;
	Stack<Node> s = new Stack<Node>();
	Node node = root;
	while(!s.isEmpty() || node!=null) {
		if(node!=null) {
			s.push(node);
			node = node.left;
		}else {
			node = s.pop();
			System.out.print(node.data+" ");
			node = node.right;
		}
	}
}
public static void iterativePostOrder(Node root) {
	if(root==null)
		return;
	Stack<Node> s = new Stack<Node>();
	s.push(root);
	Node prev = null;
	while(!s.isEmpty()) {
		Node curr = s.peek();
		if(prev==null || prev.left == curr || prev.right==curr) {
			if(curr.left!=null)
				s.push(curr.left);
			else if(curr.right!=null)
				s.push(curr.right);
		}else if(curr.left==prev) {
			if(curr.right!=null)
				 s.push(curr.right);
		}else {
			System.out.print(curr.data+" ");
			s.pop();
		}
		prev = curr;
	}
}
public static void iterativePreOrder(Node root) {
	if(root==null)
		  return;
	Stack<Node> s = new Stack<Node>();
	s.push(root);
	while(!s.isEmpty()) {
		Node temp = s.pop();
		System.out.print(temp.data+" ");
		if(temp.right!=null)
			   s.push(temp.right);
		if(temp.left!=null)
			  s.push(temp.left);
		/*for(int i=0;i<s.size();i++)
			System.out.print(s.get(i).data+" ");
		System.out.println();*/
	}
}
}
