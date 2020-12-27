package StringAlgo;

import java.util.Scanner;

public class String_number {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
    for(int t=0;t<T;t++) {
    	String str = sc.next();
    	String digit=""; int sum=0;
    	for(int i=0;i<str.length();i++) {
    		if(Character.isDigit(str.charAt(i))) {
    			digit+=str.charAt(i);
    		}
    		else {
    			
    			if(digit!="") {
    			sum += Integer.parseInt(digit);
    			digit="";
    			}
    		}
    	}
    	if(digit!="") 
			sum += Integer.parseInt(digit);
    	System.out.println(sum);
    }
}
}
