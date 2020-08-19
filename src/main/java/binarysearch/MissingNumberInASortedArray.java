package binarysearch;

public class MissingNumberInASortedArray {

    public static int missingIndex(int[] nums, int idx){
        int missingIndex = nums[idx] - nums[0] - idx;
        return missingIndex;
    }
    public static void main (String args[]){
        int[] nums = {1,2,4};
        int k =2;
        int n = nums.length;
        if (k > missingIndex(nums, n -1)) {
            System.out.println(nums[n - 1] + k - missingIndex(nums, n - 1));
        }
        int missingNumberAtKIndex = missingNumberAtIndex(nums,k);
        //if(k<nums.length){
            missingNumberAtKIndex -=1;
        //}
       int missingNumber = nums[missingNumberAtKIndex] +k - missingIndex(nums,missingNumberAtKIndex);
       System.out.println(missingNumber);
    }
    public static int missingNumberAtIndex(int[] nums, int k){
        int start = 0;
        int end = nums.length -1;
        while(start!=end){
            int mid = start + (end-start)/2;
            int missingIdx = missingIndex(nums,mid);
            if(missingIdx<k){
                start = mid +1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
