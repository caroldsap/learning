package arrays;

public class RemoveDuplicates {
public static void main (String args[]){
    int[] nums = {1,0,0,-1,-2,-2,-3};
    int count =removeDuplicates(nums);
    for(int i =0;i<nums.length;i++){
        if(i<count){
            System.out.print( nums[i]+" ");
            if(i==count-1) System.out.print("\n********************\n");

        } else {
            System.out.print(nums[i]+" ");
        }

    }
}
    public static int removeDuplicates(int nums[]){
        int j =0;
        for ( int i =0;i<nums.length;i++){
            if(nums[j]!=nums[i]){
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }
}
