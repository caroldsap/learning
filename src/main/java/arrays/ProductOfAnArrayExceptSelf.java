package arrays;

public class ProductOfAnArrayExceptSelf {

    public static void main (String args[]){
        int[] output = productExceptSelf(new int[]{2,3,5,0});
        for(int num: output){
            System.out.print(num+" ");
        }
    }
    public static int[] productExceptSelf(int[] nums){

        int[] output = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        int rightProduct = 1;
        int leftProduct = 1;
        //output[left] =1;
        for ( int i =0;i<nums.length;i++){

            leftProduct = i==0?1:nums[i-1]*leftProduct;
            if(output[left]==0){
                if(left>right){
                    output[left] =0;
                } else{
                    output[left] =leftProduct;
                }
            } else {
                output[left] =output[left]*leftProduct;
            }

            left++;
            rightProduct = right ==nums.length-1?1:nums[right+1]*rightProduct;
            output[right] =output[right]!=0?output[right]*rightProduct:rightProduct;
            right--;
        }
        return output;
    }
}
