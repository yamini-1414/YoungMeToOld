package StringAlgo;

public class BinaryStrings {
public static void main(String[] args) {
	for(int i= (int)Math.pow(2, 4);i<(int)Math.pow(2, 5);i++)
		System.out.println(Integer.toBinaryString(i).substring(1));
}
}
