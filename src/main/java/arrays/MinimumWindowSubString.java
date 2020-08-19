package arrays;

import java.util.HashMap;

public class MinimumWindowSubString {
    public static void main(String args[]){
       System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
    public static String minWindow(String s, String t) {
        if(s==null || t==null) return "";
        int[] map=new int[128];
        for(Character c:t.toCharArray()){
            map[c]++;
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        char[] arr=s.toCharArray();
        while(end<arr.length){
            if (map[arr[end]] > 0) counter--;
            map[arr[end]]--;
            end++;
            while(counter==0){
                if((end-start)<minLen){
                    minLen=end-start;
                    minStart=start;
                }
                map[arr[start]]++;
                if(map[arr[start]]>0)counter++;
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);

    }

}
