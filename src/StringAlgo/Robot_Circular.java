package StringAlgo;

import java.util.Scanner;

public class Robot_Circular {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
	    String s = sc.next();
	    System.out.println(findCircular(s)?"Circular":"Not Circular");
	}
}
public static boolean findCircular(String str) {
	
	char curr_dir='N'; int x=0; int y=0;
	for(int i=0;i<str.length();i++) {
		
		if(str.charAt(i)=='G') {
			switch(curr_dir) {
			case 'N':
				    y = y+1;
			        break;
			case 'S':
				    y= y-1;
				    break;
			case 'E':
				    x = x+1;
				    break;
			case 'W':
				    x = x-1;
				    break;
			}
			//System.out.println(x+" "+y);
		}else if(str.charAt(i)=='L') {
		 if(curr_dir=='N')
			 curr_dir='W';
		 else if(curr_dir=='W')
			 curr_dir = 'S';
		 else if(curr_dir=='S')
			 curr_dir = 'E';
		 else if(curr_dir=='E')
			 curr_dir='N';
			
	}else if(str.charAt(i)=='R') {
		 if(curr_dir=='N')
			 curr_dir='E';
		 else if(curr_dir=='W')
			 curr_dir = 'N';
		 else if(curr_dir=='S')
			 curr_dir = 'W';
		 else if(curr_dir=='E')
			 curr_dir='S';
			
	}
}
      return x==0 && y==0?true:false;	
}
}