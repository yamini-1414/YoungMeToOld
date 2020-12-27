
public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr = {1,2,3,4,5};
        for(int i=1;i<=arr.length;i++) {
        	for(int j=0;j<i;j++) {
        		for(int k=j;k<i;k++) {
        			System.out.print(k+" ");
        		}
        		System.out.println();
        	}
        }
	}

}
