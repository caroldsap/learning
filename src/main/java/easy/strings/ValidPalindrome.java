package easy.strings;



public class ValidPalindrome {

    public static void main(String args[]){

       //String input = "A man, a plan, a canal: Panama";
        String input = "B A D A B A";
       System.out.println(isPal(input));
    }

    public static boolean isPal(String s){
        StringBuilder result = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isAlphabetic(c)||Character.isDigit(c)){
                result = result.append(c);
            }
        }
        String resultLowerCase = result.toString().toLowerCase();
        int left = 0;
        int right = resultLowerCase.length()-1;
        while(left<=right){
            if(resultLowerCase.charAt(left++)!=resultLowerCase.charAt(right--)) return false;

        }
        return true;
    }
}
