package arrays;

import easy.kadanes.MaximumSubArray;

public class MaxSumContinousSubArray {

    public static void main (String args[]){
        MaxSumContinousSubArray mcs = new MaxSumContinousSubArray();
        System.out.println(mcs.maxSubArray(new int[]{1,2,3,-4,5,-1}));
    }
    public int maxSubArray(int[] nums) {
        if(nums ==null || nums.length==0) throw new IllegalArgumentException("Input array is empty or null");
        int currSum = nums[0];
        int maxSum =nums[0];
        for(int i =1;i<nums.length;i++){
            currSum  = Math.max(currSum+nums[i],nums[i]);
            maxSum  = Math.max(currSum,maxSum);
        }
        return maxSum;
    }
}
