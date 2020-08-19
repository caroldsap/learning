package arrays;

public class MergeTwoSortedArrays {
    public static void main(String args[]){
        System.out.println(11>>1);
        int[] num1 = {1,2,3,0,0,0};
        int [] num2 = {4,5,6};
        merge(num1,3,num2,3);
        for(int i :num1){
            System.out.print(i +" ");
        }

    }

    public static  void merge(int[] nums1, int m, int[] nums2, int n) {
        int i =m-1, j = n-1;
        int k = i+j+1;

        while(k>=0){
            int a = i >=0 ? nums1[i]:Integer.MIN_VALUE;
            int b = j >=0 ? nums2[j]:Integer.MIN_VALUE;
            if(a>b){
                nums1[k]=a;
               //nums1[i] = i<nums2.length-1?nums2[i]:nums1[i];
                i--;
            } else {
                nums1[k]=b;
                j--;
            }
            k--;
        }
       //System.out.println(nums1);

    }

    public static  void merge1(int[] nums1, int m, int[] nums2, int n) {
        m --;
        n --;
        int i = m + n + 1;
        while (m >=0 && n >=0) {
            if (nums1[m] > nums2[n]) {
                nums1[i--] = nums1[m--];
            }
            else {
                nums1[i--] = nums2[n--];
            }
        }
        while (m >=0) {
            nums1[i--] = nums1[m--];
        }
        while (n >=0) {
            nums1[i--] = nums2[n--];
        }


    }
    public static void merge2(int[] nums1, int m, int[] nums2, int n){
        m --;
        n --;
        for (int i = m + n + 1; i >=0; i --) {
            int a = m >=0 ? nums1[m]:Integer.MIN_VALUE;
            int b = n >=0 ? nums2[n]:Integer.MIN_VALUE;
            if (a > b) {
                nums1[i] = a;
                m --;
            }
            else {
                nums1[i] = b;
                n --;
            }
        }

    }
}
