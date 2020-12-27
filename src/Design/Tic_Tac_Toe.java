package Design;

public class Tic_Tac_Toe {
    int[][] board;
    boolean isEnd;
    int[] row ;
    int[] col ;
    int diag,xdiag;
    int count;
    Tic_Tac_Toe(int n){
    	board = new int[n][n];
    	this.row = new int[n];
    	this.col = new int[n];
    	this.diag = this.xdiag=0;
    	this.count=0;
    }
    public int move(int x,int y,int playerType) {
    	if(isEnd)
    		return -1;
    	
    	count = playerType==1?+1:-1;
    	
    	row[x]+= count;
    	col[y]+= count;
    	int n = row.length;
    	if(x==y)
    		diag+=count;
    	if(x+y==row.length-1)
    		xdiag+=count;
    	
    	if(Math.abs(row[x])==n || Math.abs(col[y])==n||Math.abs(diag)==n||Math.abs(xdiag)==n) {
    		isEnd = true;
    		return playerType;
    	}
    	
    		 return 0;
    		
    }
    public static void main(String[] args) {
    	Tic_Tac_Toe t = new Tic_Tac_Toe(3);
    	System.out.println(t.move(0, 0, 1));
    	System.out.println(t.move(0, 2, 2));
    	System.out.println(t.move(2, 2, 1));
    	System.out.println(t.move(1, 1, 2));
    	System.out.println(t.move(2, 0, 1));
    	System.out.println(t.move(1, 0, 2));
    	System.out.println(t.move(2, 1, 1));
    	System.out.println(t.move(0, 0, 1));
    	System.out.println(t.move(0, 0, 1));
    }
}
