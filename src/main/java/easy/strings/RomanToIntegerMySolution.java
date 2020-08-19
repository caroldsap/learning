package easy.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * for the problem description
 * refer https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToIntegerMySolution {
    static Map<String, Integer> romanNumerals = new HashMap<String, Integer>();

    {
        romanNumerals.put("I", 1);
        romanNumerals.put("V", 5);
        romanNumerals.put("X", 10);
        romanNumerals.put("L", 50);
        romanNumerals.put("C", 100);
        romanNumerals.put("D", 500);
        romanNumerals.put("M", 1000);
    }

    public static void main(String[] args) {
        String input = "MDCXCV";
        System.out.println(new RomanToIntegerMySolution().romanToInt(input));
    }

    public int romanToInt(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int num = 0;
        int currentVal = 0;
        int nextVal = 0;
        int pointer = 0;
        while (pointer < s.length()) {
            currentVal = romanNumerals.get(s.substring(pointer, pointer + 1));
            if (pointer < (s.length() - 1)) {
                nextVal = romanNumerals.get(s.substring(pointer + 1, pointer + 2));
            } else {

                num = num + currentVal;
                return num;
            }
            if (currentVal >= nextVal) {
                num = num + currentVal;
                pointer = pointer + 1;
            } else {
                num = num + (nextVal - currentVal);
                pointer = pointer + 2;
            }
        }
        return num;
    }
}
