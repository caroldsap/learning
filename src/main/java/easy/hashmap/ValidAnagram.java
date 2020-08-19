package easy.hashmap;

public class ValidAnagram {
    public static void main(String[] args) {
    System.out.println(isAnagram("abc","abc"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty()
        ||(s.length()!=t.length())) return false;
        int[] counter = new int[26];
        for ( int i =0;i<s.length(); i++){
            counter[s.charAt(i)-'a']++;
            counter[t.charAt(i)-'a']--;
        }
        for(int c: counter){
            if(c!=0) return false;
        }
        return true;
    }
}
