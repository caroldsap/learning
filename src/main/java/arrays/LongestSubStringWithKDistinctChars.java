package arrays;

public class LongestSubStringWithKDistinctChars {
    public static void main (String args[]){
     System.out.println(lengthOfLongestSubstringKDistinct("ABCDC",2));
    }
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] map = new int[128];
        int right = 0, left = 0, numDistinct = 0, max = 0;

        // We will utilize a left and right pointer to traverse our string
        while (right < s.length()) {
            if (map[s.charAt(right)] == 0) {
                numDistinct++;
            }
            map[s.charAt(right)]++;

            while (numDistinct > k) {
                map[s.charAt(left)]--;
                if (map[s.charAt(left)] == 0) {
                    numDistinct--;
                }
                left++;
            }

            // If the current window is greater than the max window, we update the max
            max = Math.max(right - left + 1, max);
            right++;
        }

        return max;

    }
}
