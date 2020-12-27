package Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;
public class Views {
	static class VNode{
		int hd;
		Node node;
		VNode(int hd,Node node){
			this.hd = hd;
			this.node = node;
		}
	}
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
			this.left= this.right= null;
		}
	}
	static int maxLevel;
	 static void leftViewRT(Node root,int level){
	        if(root==null) return;
	        if(maxLevel<level){
	            System.out.print(root.data+" ");
	            maxLevel = level;
	        }
	        leftViewRT(root.left,level+1);
	        leftViewRT(root.right,level+1);
	    }
	 static void leftView(Node root) {
		 maxLevel = 0;
		 leftViewRT(root,1);
	 }
	 static void bottomView(Node root) {
		 Map<Integer,Deque<Integer>> map = new TreeMap<Integer,Deque<Integer>>();
			if(root==null) return;
			Queue<VNode> q = new LinkedList<VNode>();
			q.offer(new VNode(0,root));
			while(!q.isEmpty()) {
				VNode temp = q.poll();
				Deque<Integer> dq = map.get(temp.hd);
				if(dq==null)
					dq = new LinkedList<Integer>();
				dq.add(temp.node.data);
				map.put(temp.hd,dq);
				if(temp.node.left!=null)
					q.offer(new VNode(temp.hd-1,temp.node.left));
				if(temp.node.right!=null)
					q.offer(new VNode(temp.hd+1,temp.node.right));
			}
			for(Integer key: map.keySet()){
				System.out.print(map.get(key).pollLast()+" ");
			}
	 }
	 static void printLeaves(Node root){
         if(root==null) return;
         printLeaves(root.left);
         if(root.left==null && root.right==null)
           System.out.print(root.data+" ");
         printLeaves(root.right);
     }
     static void printBoundaryLeft(Node root){
         if(root==null) return;
         if(root.left!=null) {
        	 System.out.print(root.data+" ");
        	 printBoundaryLeft(root.left);
         }else if(root.right!=null) {
        	 System.out.print(root.data+" ");
        	 printBoundaryLeft(root.right);
         }
     }
     static void printBoundaryRight(Node root) {
    	   if(root==null) return;
           if(root.right!=null) {
          	 printBoundaryRight(root.right);
          	 System.out.print(root.data+" ");
           }else if(root.left!=null) {
          	 printBoundaryRight(root.left);
          	 System.out.print(root.data+" ");
           } 
     }
	 static void boundaryTraversal(Node root) {
		 if(root==null)
			  return;
		 System.out.print(root.data+" ");
		 printBoundaryLeft(root.left);
		 printLeaves(root.left);
		 printLeaves(root.right);
		 printBoundaryRight(root.right);
	 }
	 static void rightView(Node root) {
		 if(root==null) return;
		 Queue<Node> q = new LinkedList<Node>();
		 q.offer(root);
		 q.offer(null);
		 int d=0;
		 while(!q.isEmpty()) {
			 Node temp = q.poll();
             if(temp!=null) {
            	 d = temp.data;
            	 if(temp.left!=null)
            		   q.offer(temp.left);
            	 if(temp.right!=null)
            		   q.offer(temp.right);
             }else {
            	 if(!q.isEmpty()) 
            		 q.offer(null);
            	 System.out.print(d+" ");
             }
		 }
	 }
	 static void topView(Node root) {
		 Map<Integer,Deque<Integer>> map = new TreeMap<Integer,Deque<Integer>>();
		if(root==null) return;
		Queue<VNode> q = new LinkedList<VNode>();
		q.offer(new VNode(0,root));
		while(!q.isEmpty()) {
			VNode temp = q.poll();
			Deque<Integer> dq = map.get(temp.hd);
			if(dq==null)
				dq = new LinkedList<Integer>();
			dq.add(temp.node.data);
			map.put(temp.hd,dq);
			if(temp.node.left!=null)
				q.offer(new VNode(temp.hd-1,temp.node.left));
			if(temp.node.right!=null)
				q.offer(new VNode(temp.hd+1,temp.node.right));
		}
		for(Integer key: map.keySet()){
			System.out.print(map.get(key).pollFirst()+" ");
		}
	 }
	 
	 public static void main(String[] args) {
		 Node root = new Node(20);
		 root.left = new Node(8);
		 root.right = new Node(22);
		 root.left.left = new Node(4);
		 root.left.right = new Node(12);
		 root.right.right = new Node(25);
		 root.left.right.left = new Node(10);
		 root.left.right.right = new Node(14);
		 boundaryTraversal(root);
	 }
}
