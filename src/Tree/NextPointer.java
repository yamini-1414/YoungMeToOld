package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class NextPointer {
static class Node{
	int val;
	Node left;
	Node right;
	Node next;
	Node(int val){
		this.val = val;
		this.left = this.right = this.next = null;
	}
}
public Node connect(Node root) {
	if(root==null)
		return root;
	Queue<Node> q = new LinkedList<Node>();
	q.offer(root);
	while(q.size()>0) {
		int size = q.size();
		for(int i=0;i<size;i++) {
			Node temp = q.poll();
			
			//Very important. Inorder to differ from two levels
			// A queue can have nodes of two levels at most any time
			if(i<size-1){
				temp.next = q.peek();
			}
			if(temp.left!=null)
				q.offer(temp.left);
			if(temp.right!=null)
				q.offer(temp.right);
		}
	}
	return root;
}

}
