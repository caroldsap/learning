package easy.kadanes;

public class MaximumSubArray {

    public static void main(String args[]){
        MaximumSubArray maximumSubArray = new MaximumSubArray();
        //int[] input = new int[]{2,3,-1,-2,4,-5,6,-9,11};
        int [] input =  new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maximumSubArray.maxContiguousSubarraySum(input));
    }
    public int maxContiguousSubarraySum(int[] nums) {
        int n = nums.length;
        int maximumSubArraySum = Integer.MIN_VALUE;

    /*
      We will use these outer 2 for loops to investigate all
      windows of the array.

      We plant at each 'left' value and explore every
      'right' value from that 'left' planting.

      These are our bounds for the window we will investigate.
    */
        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {
                // Let's investigate this window
                int windowSum = 0;

                // Add all items in the window
                System.out.println("******************************************");
                for (int k = left; k <= right; k++) {
                    System.out.println("left:"+left+",right:"+right+"nums["+k+"]"+nums[k]);
                    windowSum += nums[k];
                }

                // Did we beat the best sum seen so far?
                maximumSubArraySum = Math.max(maximumSubArraySum, windowSum);
            }
        }

        return maximumSubArraySum;
    }
    }
