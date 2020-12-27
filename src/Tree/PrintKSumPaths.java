package Tree;

import java.util.ArrayList;
import java.util.List;

public class PrintKSumPaths {
 static class TreeNode{
	 int  data;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int data){
		 this.data = data;
		 this.left = this.right = null;
	 }
 }
 static List<Integer> arr ;
 public static void printSum(int target,TreeNode root) {
	 arr = new ArrayList<Integer>();
	 printKPaths(root,target);
 }
 public static  void printKPaths(TreeNode root,int target) {
	 if(root==null)
		 return;
	 arr.add(root.data);
	 printKPaths(root.left,target);
	 printKPaths(root.right,target);
	 int sum=0;
	 for(int k=arr.size()-1;k>=0;k--) {
		 sum += arr.get(k);
		 if(sum==target) {
			 for(int i=k;i<arr.size();i++)
				 System.out.print(arr.get(i)+" ");
			 System.out.println();
		 }
	 }
	 arr.remove(arr.size()-1);
	 
 }
 public static void main(String[] args) {
	 TreeNode root = new TreeNode(1);
	 root.left = new TreeNode(3);
	 root.left.left = new TreeNode(2);
	 root.left.right = new TreeNode(1);
	 root.left.right.left = new TreeNode(1);
	 root.right = new TreeNode(-1);
	 root.right.left = new TreeNode(4);
	 root.right.right = new TreeNode(5);
	 root.right.left.left = new TreeNode(1);
	 root.right.left.right = new TreeNode(2);
	 root.right.right.right = new TreeNode(6);
	 printSum(5,root);
 }
}
