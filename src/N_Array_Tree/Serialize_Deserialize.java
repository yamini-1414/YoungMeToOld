package N_Array_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Serialize_Deserialize {
	static class Node{
		int val;
		List<Node> children;
		Node(int val){
			this.val = val;
		}
	}
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root==null)
            return "null";
        ArrayList<Integer> res = new ArrayList<Integer>();
        serializeUtil(root,res);
        return res.toString();
    }
    public void serializeUtil(Node root,ArrayList<Integer> res){
        if(root==null){
            return;
        }
        res.add(root.val);
        res.add(root.children.size());
        for(Node child:root.children)
            serializeUtil(child,res);
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.equals("null"))return null;
        String[] d = data.substring(1,data.length()-1).split(", ");
        Queue<String> q = new LinkedList<>(Arrays.asList(d));
        return deserializeHelper(q);    
    }
    public Node deserializeHelper(Queue<String> q){
        String val = q.poll();
        Node root  = new Node(Integer.parseInt(val));
        int child =  Integer.parseInt(q.poll());
        root.children = new ArrayList<Node>();
        for(int i=0;i<child;i++)
          root.children.add(deserializeHelper(q));
        return root;
    }
}
