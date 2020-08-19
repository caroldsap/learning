package heaps;

import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main (String args[]){
        int result = KthLargestElement.findKthLargest(new int[] { 3, 1, 5, 12, 2, 11,13,14,15 }, 4);
        System.out.println("Here are the top K numbers: " + result);

        result = KthLargestElement.findKthLargest(new int[] { 5, 12, 14,11, -1, 12 }, 1);
        System.out.println("Here are the top K numbers: " + result);
    }

    public  static int findKthLargest(int[] nums, int k) {
        return quickSelector(nums, 0 , nums.length - 1 , nums.length - k + 1);
    }

    public static int quickSelector(int[] nums, int start, int end ,int k){
        if(start == end && k == 1) return nums[start];
        int left = start;
        int right = end;
        int pivot = nums[left + (right - left)/2];
        while(left <= right){
            while(left <= right && nums[left] < pivot){
                left++;
            }
            while(left <= right && nums[right] > pivot){
                right--;
            }
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        if(start + k - 1 <= right){
            return quickSelector(nums,start,right,k);
        }else if (start + k - 1 >= left){
            return quickSelector(nums, left,end, k - (left - start));
        }else{
            return nums[right+1];
        }

    }

    public int findKthLargestUsingHeaps(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2)->n1-n2);

        for ( int i =0;i<k;i++){
            minHeap.add(nums[i]);
        }

        for ( int i =k ;i<nums.length;i++){
            if(nums[i]>minHeap.peek()){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
