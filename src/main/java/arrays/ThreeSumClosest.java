package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSumClosest {

    public static void main (String args[]){
        ThreeSumClosest threeSum = new ThreeSumClosest();
        int result = threeSum.threeSumClosest(new int[]{-1,2,1,-4,5},9);
        System.out.println(result);
    }
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int closed = 0;
        for (int i = 0; i < nums.length; i ++){
            if (i == 0 || nums[i] != nums[i-1]){
                int start = i + 1;
                int end = nums.length - 1;
                while (start < end){
                    int sum = nums[i] + nums[start] + nums[end];
                    if (Math.abs(sum - target) < min){
                        min = Math.abs(sum - target);
                        closed = sum;
                    }
                    if (sum < target){
                        start ++; }
                    else{ // >= target
                        end --;
                    }//if
                }//while
            }//if
        }//for
        return closed;
    }
}
