package arrays;

public class SortColours {

    public void sortColors(int[] nums) {
        int i =0, cloud0 = 0, cloud2=nums.length-1;
        while(i<=cloud2){
            if(nums[i]==2){
                swap(nums,i,cloud2);
                cloud2--;
            } else if(nums[i]==0){
                swap(nums,i,cloud0);
                cloud0++;
                i++;
            } else {
                i++;
            }
        }
    }
    public void swap(int nums[],int fromIndex, int toIndex){
        int temp = nums[fromIndex];
        nums[fromIndex] = nums[toIndex];
        nums[toIndex] = temp;
    }
}
