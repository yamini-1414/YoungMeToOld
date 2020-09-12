package Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AutoCompleteSystem {
	static Map<String,Integer> freq;
 static class TrieNode{
	TrieNode[] child;
	List<String> arr;
	TrieNode(){
		this.child = new TrieNode[27];
		arr = new ArrayList<String>();
	}
}
static TrieNode root;
public static void insert(String str) {
	if(str.length()==0) return;
	TrieNode temp = root;
	for(int i=0;i<str.length();i++) {
		int index = str.charAt(i)==' '?26: str.charAt(i)-'a';
		if(temp.child[index]==null)
			temp.child[index] = new TrieNode();
		temp = temp.child[index];
		temp.arr.add(str);
		Collections.sort(temp.arr,(a,b)->freq.get(a)!=freq.get(b)?freq.get(b)-freq.get(a):a.compareTo(b));
	    if(temp.arr.size()>3) temp.arr.remove(temp.arr.size()-1);
	}
}
public static boolean isEnd(TrieNode node) {
	if(node==null) return true;
	for(int i=0;i<27;i++)
		if(node.child[i]!=null)
			return false;
	return true;
}

}
