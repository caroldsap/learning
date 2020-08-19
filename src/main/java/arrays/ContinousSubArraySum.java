package arrays;

import java.util.HashMap;
import java.util.Map;

public class ContinousSubArraySum    {
    public static void main(String args[]){
        //System.out.println(checkSubarraySum(new int[]{23,2,4,6,7},-6));
        System.out.println(checkSubarraySum(new int[]{0,1,0},0));
    }
    public  static boolean checkSubarraySum(int[] nums, int k) {
        int currSum =0;
        Map prefixSums = new HashMap();
        for ( int i =0;i<nums.length;i++){
            currSum+= nums[i];
            int complement = currSum - k;
            if(prefixSums.containsKey(complement)){
                return true;
            }
            prefixSums.put(currSum,i+1);
        }
        if(k!=0 && currSum%k ==0) return  true;

        return false;
    }
}
