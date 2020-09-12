package TwoPointer;

public class TrappingRainWater {
public static  void main(String[] args) {
	int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
	int left=0; int right= height.length-1; int level=0; int res=0;
	while(left<right) {
		int lower = height[height[left]<height[right]?left++:right--];
		level = Math.max(level, lower);
		res +=level-lower;
		System.out.print(lower+" ");
	}
}
}
