package Bit_Manipulation;

public class Power_of_2 {
public static void main(String[] args) {
	int x = 4;
    System.out.println(x!=0 && ((x &(x-1))==0));
}
}
