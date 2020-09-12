package StringAlgo;

import java.util.HashMap;
import java.util.Scanner;

public class Roman_2_Integer {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		System.out.println(convertRoman(sc.next()));
	}
}
public static int convertRoman(String str) {
	HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	map.put('I',1);
	map.put('V',5);
	map.put('X',10);
	map.put('L',50);
    map.put('C',100);
    map.put('D',500);
    map.put('M',1000);
    int total=0;
    for(int i=0;i<str.length()-1;i++) {
    	if(map.get(str.charAt(i))>=map.get(str.charAt(i+1)))
    		total+=map.get(str.charAt(i));
    	else
    		total-=map.get(str.charAt(i));
    }
    total+= map.get(str.charAt(str.length()-1));
    return total;
}
}
