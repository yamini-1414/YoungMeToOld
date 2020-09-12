package Trie;

public class Implement_trie {
static class Node{
	boolean isEnd;
	Node[] child;
	Node(){
		this.isEnd = false;
		child = new Node[26];
	}
}
static Node root = new Node();
public static void insert(String str) {
	if(str.length() ==0 ) return;
	Node temp = root;
	for(int i=0;i<str.length();i++) {
		int index = str.charAt(i)-'a';
		if(temp.child[index]==null)
			temp.child[index] = new Node();
		temp = temp.child[index];
	}
	temp.isEnd = true;
}
public static boolean search(String str) {
	if(str.length()==0) return true;
	Node temp  = root;
	for(int i=0;i<str.length();i++) {
		int index  = str.charAt(i)-'a';
		if(temp.child[index]==null) return false;
		temp = temp.child[index];
	}
	return temp.isEnd;
}
public static Node delete(Node root,String str,int depth) {
	if(root==null)
		return root;
	if(depth==str.length()) {
		if(root.isEnd)
			root.isEnd = false;
		if(isEmpty(root))
			root= null;
	}else {
	int index = str.charAt(depth)-'a';
	root.child[index] = delete(root.child[index],str,depth+1);
	if(!root.isEnd && isEmpty(root))
		root= null;
	}
	return root;
}
public static void printTrie(Node root, String str) {
	if(root.isEnd) {
		System.out.println(str);
		return;
	}
	for(int i=0;i<26;i++) {
		if(root.child[i]!=null) 
			printTrie(root.child[i],str+(char)('a'+i));
		    
	}
}
public static boolean isEmpty(Node root) {
    if(root==null) return true;
    for(int i=0;i<26;i++)
    	if(root.child[i]!=null)
    		return false;
    return true;
}
public static void main(String[] args) {
	insert("ravi");
	insert("shankar");
	insert("swati");
	insert("priya");
	insert("saurabh");
	insert("yamini");
	insert("ashwini");
	StringBuffer str = new StringBuffer();
	printTrie(root,"");
	System.out.println(search("ravi"));
}
}
