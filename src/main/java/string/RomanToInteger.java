package string;

public class RomanToInteger {

    public static void main(String[] args) {

        RomanToInteger r = new RomanToInteger();
        System.out.println(r.romanToInt("IV"));
    }

    public int romanToIntValue(char c) {
        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;

        if (c == 'C') return 100;
        if (c == 'D') return 500;
        if (c == 'M') return 1000;
        return -1;
    }

    public int romanToInt(String s) {
        int result  = 0;
        int currentNum =0;
        int prevNum =0;
        for(int i = s.length()-1;i>=0;i--){
            currentNum = romanToIntValue(s.charAt(i));
            result+= currentNum>=prevNum?currentNum:-currentNum;
            prevNum = currentNum;
        }
        return result;
    }
}
