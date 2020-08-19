package arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        //int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        //int [] heights = {2,1,0,2};
        //int[] heights = {0,2,0};
       // int[] heights = {5,2,1,2,1,5};
        ///int [] heights = {1,2,3,4,3,2,1};
        int[] heights = {1,3,2,1,3,5};
        int totalWater = trap(heights);
        System.out.println(totalWater);
    }


    public static int trap(int[] height) {

        if (height.length<3) return 0;
        int left = 0, right = height.length-1;
        int leftMax=0, rightMax=0;
        int ans = 0;
        int elementAtLeft = 0, elementAtRight = 0;
        while (left < right) {
            // if (height[left] > leftMax) leftMax = height[left];
            // if (height[right] > rightMax) rightMax = height[right];
            elementAtLeft = height[left];
            elementAtRight = height[right];
            leftMax = Math.max(leftMax,elementAtLeft);
            rightMax = Math.max(rightMax,elementAtRight);
            if (leftMax < rightMax) {
                ans += Math.max(0, leftMax-elementAtLeft);
                left++;
            } else {
                ans += Math.max(0, rightMax-elementAtRight);
                right--;
            }
        }
        return ans;

    }
    public static int trapMyApproachNotWorking(int[] height) {
        int totalWater = 0;
        int left = 0, right =0, diff =0;
        for ( int i =1;i<height.length-1;i++){
            left = height[i-1];
            right = height[i+1];
            if(right ==0 ){
                right = i!=height.length-2?height[i+2]:0;
                diff = right!=0?(left +  right) - height[i]:0;
                i++;
            }
            else if(left == right) {
                diff = left - height[i];
            } else {
                diff = Math.abs(left - right) - height[i];
                if(height[i]<left && height[i]<right){
                    diff = Math.abs(diff);
                }

            }
            if(diff>0) totalWater+=diff;

        }
        return totalWater;
    }
}
