package Arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LargestNumber {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		System.out.println(largestNumber(arr));
	}
}
	
	
	public static class StringComparator implements Comparator<String>{
		public int compare(String str1,String str2){
		    String a = str1+str2;
			String b = str2+str1;
			return b.compareTo(a);
		}
	}
		public static String largestNumber(int[] arr){
		String[] result = new String[arr.length];
		for(int i=0;i<arr.length;i++)
		  result[i] = String.valueOf(arr[i]);
		Arrays.sort(result,new StringComparator());
		StringBuilder str = new StringBuilder();
		for(int i=0;i<arr.length;i++)
		   str.append(result[i]);
		 return str.toString();
		}

}
