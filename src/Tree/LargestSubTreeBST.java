package Tree;

public class LargestSubTreeBST {
	
	  class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	 
	      TreeNode(int x) {
	       val = x;
	       left=null;
	       right=null;
	      }
	  }
	 
	    static class Info{
	        int min;
	        int max;
	        int size;
	        boolean isBST;
	        Info(){
	            this.min = Integer.MAX_VALUE;
	            this.max = Integer.MIN_VALUE;
	            this.size = 0;
	            this.isBST = false;
	        }
	    }
	    public int solve(TreeNode A) {
	        return solveUtil(A).size;
	        
	    }
	    public Info solveUtil(TreeNode root){
	        Info info = new Info();
	        if(root==null){
	            info.isBST = true;
	            return info;
	        }
	          
	        Info l  = solveUtil(root.left);
	        Info r = solveUtil(root.right);
	        info.max = Math.max(r.max,root.val);
	        info.min = Math.min(l.min,root.val);
	        if(l.isBST && r.isBST && l.max<=root.val && r.min>=root.val){
	            info.size = 1+l.size+r.size;
	            info.isBST = true;
	        }else{
	            info.size = Math.max(l.size,r.size);
	            info.isBST = false;
	        }
	        return info;
	    }
	}

