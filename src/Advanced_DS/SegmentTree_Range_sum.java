package Advanced_DS;

public class SegmentTree_Range_sum {
int[] arr; // the array which is used to construct the segment tree
int[] tree;
SegmentTree_Range_sum(int[] arr){
	this.arr = arr;
	int n = arr.length;
	this.tree = new int[2*n-1];
	
}
// Time complexity for build is O(N)
public void buildTree(int index,int start,int end) {
	if(start==end) {
		tree[index] = arr[start];
		return;
	}
	int mid = (start+end)/2;
	buildTree(2*index+1,start,mid);
	buildTree(2*index+2,mid+1,end);
	tree[index] = tree[2*index+1] + tree[2*index+2];
}
// Time complexity for query is O(logN)
public int query(int index,int start,int end,int l,int r) {
	//3 conditions
	// 1.the given interval is out of range
	if(r<start || end<l)
		return 0;
	//2. the range is within interval
	if(start>= l && end<=r)
		return tree[index];
	int mid = (start+end)/2;
	int p1 = query(2*index+1,start,mid,l,r);
	int p2 = query(2*index+2,mid+1,end,l,r);
	return p1+p2;
}
public void update(int index,int start,int end,int idx,int diff) {
  if(start==end) {
	  tree[index] += diff;
	  arr[start] += diff;
	  return;
  }
  int mid = (start+end)/2;
  if(start>= idx && idx<= mid)
	  update(2*index+1,start,mid,idx,diff);
  else 
	  update(2*index+2,mid+1,end,idx,diff);
  tree[index] = tree[2*index+1] + tree[2*index+2];
}
public static void main(String[] args) {
	int[] arr = {1,2,3,4,5,6,7};
	SegmentTree_Range_sum  test = new SegmentTree_Range_sum(arr);
	int n = arr.length;
	test.buildTree(0, 0, n-1);
	System.out.println(test.query(0,0,n-1,3,5));
	test.update(0, 0, n-1, 4, 5);
	System.out.println(test.query(0,0,n-1,3,5));
	
}
}
