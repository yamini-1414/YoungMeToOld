package Trie;

import java.util.ArrayList;
import java.util.List;

public class SearchSugggestions{
static class TrieNode{
	boolean isEnd;
	TrieNode[] child;
	TrieNode(){
		this.isEnd = false;
		this.child = new TrieNode[26];
	}
}
static TrieNode root;
public static void insert(String s) {
	if(s.length()==0)  return;
	TrieNode temp = root;
	for(int i=0;i<s.length();i++) {
		int index = s.charAt(i)-'a';
		if(temp.child[index]==null)
			temp.child[index] = new TrieNode();
		temp = temp.child[index];
	}
	temp.isEnd = true;
}
public static TrieNode searchPrefix(String s) {
	if(s.length()==0) return null;
	TrieNode temp = root;
	for(int i=0;i<s.length();i++) {
		int index = s.charAt(i)-'a';
		if(temp.child[index]==null)
			return null;
		temp = temp.child[index];
	}
	return temp;
}
public static void traverse(String prefix,TrieNode node,List<String> res) {
     	if(node.isEnd) {
     		res.add(prefix);
     	}
     	if(res.size()==3) return;
     	if(isEmpty(node)) return;
     	for(int i=0;i<26;i++) {
     		if(node.child[i]!=null) {
     			char ch = (char)(i +97);
     			traverse(prefix+ch,node.child[i],res);
     			if(res.size()==3) return;
     		}
     	}
}
public static boolean isEmpty(TrieNode root) {
	if(root==null) return true;
	for(int i=0;i<26;i++) {
		if(root.child[i]!=null)
			return false;
	}
	return true;
}
public static void main(String[] args) {
	String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
	String searchWord = "mouse";
	List<List<String>> res = new ArrayList<List<String>>();
	root = new TrieNode();
	for(String prod: products)
		insert(prod);
	for(int i=1;i<=searchWord.length();i++) {
		String word = searchWord.substring(0,i);
		TrieNode node = searchPrefix(word);
		List<String> r = new ArrayList<String>();
		traverse(word,node,r);
		res.add(new ArrayList<String>(r));
	}
	System.out.println(res);
	
}
}
