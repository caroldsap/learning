package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubStringWithoutRepeatingChars {
    public static void main (String args[]){
        int len = lengthOfLongestSubstring("ABCDAE");
        System.out.println(len);
    }
    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int [] mapping = new int[128];
        int maximum = 0;

        while(end < s.length()) {
            //If the character has already been seen at a position after start, then update start
            start = Math.max(start, mapping[s.charAt(end)]);
            mapping[s.charAt(end)] = end + 1;
            maximum = Math.max(end - start + 1, maximum);
            end ++;
        }
        return maximum;
    }
}
