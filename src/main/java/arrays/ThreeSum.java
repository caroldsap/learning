package arrays;

import java.util.*;

public class ThreeSum {

    public static void main (String args[]){
        ThreeSum threeSum = new ThreeSum();
        List result = threeSum.threeSum(new int[]{-2,0,0,2,2},0);
        for(int i =0;i<result.size();i++){
            List triplet = (List) result.get(i);
            System.out.println(triplet);
     }
    }
    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        List<Integer> tmp = null;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int start = i + 1, end = nums.length - 1;
                while (start < end) {
                    int sum = nums[i] + nums[start] + nums[end];
                    if (sum == target){
                         tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[start]);
                        tmp.add(nums[end]);
                        result.add(tmp);
                        int startVal = nums[start];
                        int endVal = nums[end];
                        while (start < end && startVal == nums[start]) {
                            start ++;
                        }
                        while (end > start && endVal == nums[end]) {
                            end --;
                        }

                    }
                    else if (sum < target) {
                        start ++;
                    }
                    else {
                        end --;
                    }
                }
            }
        }
        return result;
    }
}
