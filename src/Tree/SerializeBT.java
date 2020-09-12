package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBT {
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	   // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<Integer> r = new ArrayList<Integer>();
        serializeHelper(root,r);
        return r.toString();
    }
    public void serializeHelper(TreeNode root,ArrayList<Integer> res) {
    	if(root==null) {
    		res.add(null);
            return ;
    	}
    	res.add(root.val);
    	serializeHelper(root.left,res);
    	serializeHelper(root.right,res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<String>();
        String[] d = data.substring(1, data.length()-1).split(",");
        for(String str:d)
        	q.add(str);
        return deserialize(q);
    }
    public TreeNode deserialize(Queue<String> q) {
    	   String s = q.poll();
    	   if(s=="null")
    		   return null;
    	   TreeNode root = new TreeNode(Integer.parseInt(s));
    	   root.left = deserialize(q);
    	   root.right = deserialize(q);
    	return root;
    }
}
