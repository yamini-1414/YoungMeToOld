package StringAlgo;

public class Generate_substrings {
public static void main(String[] args) {
	String A = "ilovesamsungmobiles";
	int count=0;
	for(int i=0;i<A.length();i++) {
		for(int j=1;i+j<=A.length() ;j++)
			System.out.println(A.substring(i,i+j)+"  "+count++);
	}
}
}
