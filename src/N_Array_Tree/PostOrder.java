package N_Array_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {
static class Node{
	int val;
	List<Node> children;
	Node(int val){
		this.val = val;
		this.children = new ArrayList<Node>();
	}
}
public void postOrderIter(Node root) {
	if(root==null)
		return;
	Stack<Node> s1 = new Stack<Node>();
	Stack<Node> s2 = new Stack<Node>();
	s1.push(root);
	while(!s1.isEmpty()) {
		Node temp = s1.pop();
		s2.push(temp);
		for(Node children: temp.children) {
			if(children!=null)
			   s1.push(children);
		}
	}
	while(!s2.isEmpty())
		System.out.print(s2.pop().val);
}
}
