package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConvertTreeToGraph {
static class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val = val;
		this.left = this.right = null;
	}
}
public static TreeNode root;
public static HashMap<Integer,List<Integer>> map;
public static void main(String[] args) {
	map = new HashMap<Integer,List<Integer>>();
	 root = new TreeNode(3);
	 root.left = new TreeNode(5);
	 root.right = new TreeNode(1);
	 root.left.left = new TreeNode(6);
	 root.left.right = new TreeNode(2);
	 root.left.right.left = new TreeNode(7);
	 root.left.right.right = new TreeNode(4);
	 root.right.left = new TreeNode(0);
	 root.right.right = new TreeNode(8);
	 buildMap(root,null);
	 List<Integer> res = new ArrayList<Integer>();
	 boolean[] visited = new boolean[map.size()];
	 //dfs(5,visited,2,0,res);
	 bfs(5,visited,2,res);
	 System.out.println(res);
}
static void buildMap(TreeNode root,TreeNode parent) {
	if(root==null) return;
	if(!map.containsKey(root.val)) {
		List<Integer> list = new ArrayList<Integer>();
		map.put(root.val,list);
		if(parent!=null) {
			map.get(root.val).add(parent.val);
			map.get(parent.val).add(root.val);
		}
		buildMap(root.left,root);
		buildMap(root.right,root);
	}
}
static void dfs(int target,boolean[] visited,int K,int length,List<Integer> res) {
	if(visited[target]) return;
	visited[target] = true;
	if(length==K) {res.add(target); return;}
	for(int next:map.get(target))
		if(!visited[next])
			dfs(next,visited,K,length+1,res);
}
static void bfs(int target,boolean[] visited,int K,List<Integer> res) {
	Queue<Integer> q = new LinkedList<Integer>();
	q.offer(target);
	visited[target] = true; int len=0;
	while(!q.isEmpty()) {
		int size = q.size();
		for(int i=0;i<size;i++) {
			int temp = q.poll();
			if(len==K) res.add(temp);
			for(int next:map.get(temp)) {
				if(!visited[next]) {
					q.offer(next);
					visited[next] = true;
				}
			}
		}
		len++;
	}
}
}
