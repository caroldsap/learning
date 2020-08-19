package arrays;

import java.util.HashMap;

public class SubArraySumEqualsK {
    public static void main(String args[]){
    System.out.println(subarraySum(new int[]{1,2,4,-4,7},3));
    }
    public static int subarraySum(int[] nums, int k) {
        int res = 0, sum = 0;
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        count.put(0, 1);
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            if (count.containsKey(sum - k)) {
                res += count.get(sum - k);
            }

            count.put(sum, count.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
