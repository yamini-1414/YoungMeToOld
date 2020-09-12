package StringAlgo;

import java.util.Scanner;

public class Look_and_say {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for(int t=0;t<T;t++) {
    	int n = sc.nextInt();
    	System.out.println(pattern(n));
    }
  } 
  public static String pattern(int n) {
	  
	  StringBuilder prev = new StringBuilder();
	  StringBuilder next = new StringBuilder();
	  prev.append('1');
	  for(int i=2;i<=n;i++) {
		  int index= 0; int len=0; int end=0;
		  while(end<prev.length()) {
			   len=0;
			  while(end<prev.length() && 
					  prev.charAt(index)==prev.charAt(end)) {
				  len++; end++;
			  }
				  next.append(len);
				  next.append(prev.charAt(index));
				  index= end;
			  }
		     prev = new StringBuilder(next);
		     next = new StringBuilder("");
		  }
	    return prev.toString();
	  }
}
