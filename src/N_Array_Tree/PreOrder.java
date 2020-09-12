package N_Array_Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PreOrder {
static class Node{
	int val;
	List<Node> children;
	Node(int val){
		this.val = val;
		this.children = new ArrayList<Node>();
	}
}
public void preOrder_Iterative(Node root) {
	if(root==null)
		return;
	Stack<Node> s = new Stack<Node>();
	s.push(root);
	while(!s.isEmpty()) {
		Node temp = s.pop();
		System.out.print(temp.val+" ");
		Collections.reverse(temp.children);
		for(Node children:temp.children)
			s.push(children);
	}
}
public void preOrderRecur(Node root) {
	if(root!=null) {
		System.out.print(root.val+" ");
		for(Node children: root.children) 
			preOrderRecur(children);
	}
}

}
