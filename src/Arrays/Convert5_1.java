package Arrays;

import java.util.Scanner;

public class Convert5_1 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int num = sc.nextInt();
		System.out.println(convert(num));
	}
}
static int convert(int num) {
	String str = Integer.toString(num);
	str.replace('0', '5');
	return Integer.parseInt(str);
}
}
