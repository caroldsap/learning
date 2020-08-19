package easy.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithoutrepeatingcharacters {

    public static void main(String[] args) {
        String input = "abcdeabab";
        //System.out.println(bestApproach(input));
       //System.out.println(getUniqueCharacterSubstring(input));
        System.out.println(getUniqueCharacterSubStringBestApproach(input));
    }
    static String getUniqueCharacterSubStringBestApproach(String s){
        int start = 0;
        int end = 0;
        int [] mapping = new int[128];
        int maximum = 0;
        String output = "";
        while(end < s.length()) {
            //If the character has already been seen at a position after start, then update start
            start = Math.max(start, mapping[s.charAt(end)]);
            //System.out.println("s.charAt(end):"+s.charAt(end)+ ",start:"+start);
            mapping[s.charAt(end)] = end + 1;
            maximum = Math.max(end - start + 1, maximum);
            if (output.length() < end - start + 1) {
                output = s.substring(start, end + 1);
            }
            end ++;
        }
        return output;
    }

    /**
     * Using Sliding Window Technique
     * @param input
     * @return
     */
    static String getUniqueCharacterSubstring(String input) {
        Map<Character, Integer> visited = new HashMap<>();
        String output = "";
        for (int start = 0, end = 0; end < input.length(); end++) {
            char currChar = input.charAt(end);
            //if (visited.containsKey(currChar)) {
                start = Math.max(visited.getOrDefault(currChar,0) + 1, start);
            //}
            if (output.length() < end - start + 1) {
                output = input.substring(start, end + 1);
            }
            visited.put(currChar, end);
        }
        return output;
    }

    static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> visited = new HashMap<>();
        int maxLen = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            char currChar = s.charAt(end);
            if (visited.containsKey(currChar)) {
                start = Math.max(visited.get(currChar) + 1, start);
            }
            if (maxLen < end - start + 1) {

                maxLen = end - start;
            }
            visited.put(currChar, end);
        }
        return maxLen;
    }
    static int bestApproach(String s){
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

