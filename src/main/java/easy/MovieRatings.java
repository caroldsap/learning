package easy;

public class MovieRatings {
    public static void main (String args[]){
/**
 *  int[] input = { -3, 2, 4, -1, -2, -5 };//4
 *             int[] opt = new int[input.Length + 2];
 *             for (int i = input.Length - 1; i >= 0; i--)
 *                 opt[i] = input[i] + Math.Max(opt[i + 2], opt[i + 1]);
 *
 *             Console.WriteLine(Math.Max(opt[0], opt[1])
 */
        int input[] = {9,-1,-3,-4,-5};
        int[] output = new int[input.length +2];
        for(int i =input.length -1 ;i>=0;i--){
            output[i] = input [i] + Math.max(output[i+2],output[i+1]);
        }
        for(int i =0;i<output.length;i++){
            System.out.print(output[i]+" ");
        }
        System.out.println("\n"+output[0] +" , "+output[1]);
        int maxSum = 0;

        int[] maxSumArray = new int[]{0,0};
        for(int i =input.length -1 ;i>=0;i--){
            maxSum = input [i] + Math.max(maxSumArray[0],maxSumArray[1]);
            int temp = maxSumArray[0];
            maxSumArray[0] = maxSum;
            maxSumArray[1] = temp;

        }

        System.out.println(maxSumArray[0] + " , " +maxSumArray[1]);

    }
}
