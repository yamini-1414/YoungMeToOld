package StringAlgo;

import java.util.Arrays;

public class StringComparsion {
public static class SNode{
	int rank;
	String str;
	SNode(int rank,String str){
		this.rank = rank;
		this.str = str;
	}
}

public static void main(String[] args) {
   SNode[] nodes = new SNode[4];
   nodes[0] = new SNode(5,"i love you");
   nodes[1] = new SNode(3,"island");
   nodes[2] = new SNode(2,"ironman");
   nodes[3] = new SNode(2,"i love leetcode");
   Arrays.sort(nodes, (a,b)->a.rank!=b.rank?b.rank-a.rank:a.str.compareTo(b.str));
   for(int i=0;i<nodes.length;i++)
	   System.out.println(nodes[i].str);
   
}
}
