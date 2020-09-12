 /*package whatever //do not write package name here */
package Trie;
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
static class Node{
	   char data;
	   boolean visited;
	   Node(char data){
		   this.data = data;
		   this.visited = false;
	   }
   }
   static class Trie{
	   static class TrieNode{
		    boolean isEnd;
		    TrieNode[] child;
		    TrieNode(){
		    	this.isEnd = false;
		    	this.child = new TrieNode[26]; 
		    }
	   }
	   TrieNode root= new TrieNode();
	   void insert(String str) {
		    if(str.length()==0)
		    	 return;
		    TrieNode temp = root;
		    for(int i=0;i<str.length();i++) {
		        int index =Character.isUpperCase(str.charAt(i))?str.charAt(i)-'A':str.charAt(i)-'a';
		    	if(temp.child[index]==null)
		    		temp.child[index] = new TrieNode();
		    	temp = temp.child[index];
		    }
		    temp.isEnd = true;
	   }
	   boolean search(String str) {
		   TrieNode temp = root;
		   for(int i=0;i<str.length();i++) {
			     int index =Character.isUpperCase(str.charAt(i))?str.charAt(i)-'A':str.charAt(i)-'a';
			   if(temp.child[index]==null)
				   return false;
			   temp = temp.child[index];
		   }
		   return temp.isEnd;
	   }
	   
   }
   static Node[][] nodes;
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   int T = sc.nextInt();
	   for(int t=0;t<T;t++) {
	   int k = sc.nextInt();
	   Trie trie = new Trie();
	   int maxLen=0;
	   for(int i=0;i<k;i++){
	       String str = sc.next();
	       maxLen = Math.max(maxLen,str.length());
		   trie.insert(str);
	   }
	   int n = sc.nextInt();
	   int m = sc.nextInt();
	   nodes = new Node[n][m];
	   for(int i=0;i<n;i++)
		   for(int j=0;j<m;j++)
			nodes[i][j] = new Node(sc.next().charAt(0));
	   Set<String> res = new TreeSet<String>();
	   
	  for(int i=0;i<n;i++) {
		   for(int j=0;j<m;j++) {
				   dfsUtil(i,j,"",res,maxLen);
		   }
	   }
       boolean flag = false;
	   for(String str:res) {
		   if(str.length()<=maxLen && trie.search(str)){
			   System.out.print(str+" ");
			   flag = true;
		   }
	   }
	   if(!flag) System.out.print("-1 ");
	   System.out.println();
	   }
   }
  static void dfsUtil(int x,int y,String s,Set<String> res,int maxLen) {
	   if(!isValid(x,y))
		   return;
	  
	   s +=nodes[x][y].data;
	   nodes[x][y].visited = true;
	   res.add(s);
	   int[] dx = {-1,+1,0,0,+1,+1,-1,-1};
	   int[] dy = {0,0,+1,-1,+1,-1,+1,-1}; 
	   for(int i=0;i<dx.length;i++) {
		   int n_x = x+dx[i];
		   int n_y = y+dy[i];
		   if(isValid(n_x,n_y)) {
			   nodes[x][y].visited=true;
			   if(s.length()>maxLen)
			     break;
			   dfsUtil(n_x,n_y,s,res,maxLen);
		   }
	   }
	   s = ""+s.charAt(s.length()-1);
	   nodes[x][y].visited = false;
	  
   }
  static boolean isValid(int x,int y) {
	   if(x>=0 && x<nodes.length && y>=0 && y<nodes[0].length && !nodes[x][y].visited)
		   return true;
	   return false;
   }
}