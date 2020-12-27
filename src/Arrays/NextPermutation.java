package Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length==0) return;
        int k =-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                k = i;
                break;
            }
        }
        if(k!=-1){
        for(int j=nums.length-1;j>=0;j--){
            if(nums[j]>nums[k]){
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                break;
            }
          }
        }
        int start = k+1 ;int end = nums.length-1;
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++; end--;
        }
    }
}
