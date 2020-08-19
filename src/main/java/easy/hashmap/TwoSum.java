package easy.hashmap;

import sun.awt.image.ImageWatched;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] result=twoSum(new int[]{3,2,4},6);
    System.out.println(result[0] +","  +result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        int targetValue = 0;
        for (int i = 0; i < nums.length; i++) {
            targetValue = target - nums[i];
            if (map.containsKey(targetValue)) {

                return new int[] { map.get(targetValue  ), i };
            } else {
                map.put(nums[i], i);
            }


        }
        return indices;
    }
}
