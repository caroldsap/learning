package string;

public class StringToAtoi {
    public static void main(String args[]){

        StringToAtoi s = new StringToAtoi();
        int result = s.myAtoi("   12");
        System.out.println(result);
    }
    public int myAtoi(String str) {
        int i=0, sign = 1;
        int ans = 0;
      while(i<str.length() && str.charAt(i) == ' '){
            i++;
        }

      //str = str.trim();
        if(i<str.length() && str.charAt(i) == '-'){
            sign = -1;
            i++;
        } else if(i<str.length() && str.charAt(i) == '+'){
            i++;
        }



        while(i<str.length() && '0' <= str.charAt(i) && str.charAt(i) <= '9'){
            if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && str.charAt(i)-'0' > Integer.MAX_VALUE % 10)){
                if(sign == 1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }


            ans = ans*10 + (str.charAt(i) - '0');
            i++;
        }

        return ans*sign;

    }
}
