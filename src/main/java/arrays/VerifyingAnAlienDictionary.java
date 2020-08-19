package arrays;

public class VerifyingAnAlienDictionary {
    public static int[] char_map = new int[26];
    public static void main(String[] args) {
        VerifyingAnAlienDictionary v = new VerifyingAnAlienDictionary();
        boolean result  = false;
        String[] words = {"zirqhpfscx","zrmvtxgelh","vokopzrtc","nugfyso"
                ,"rzdmvyf","vhvqzkfqis","dvbkppw","ttfwryy","dodpbbkp","akycwwcdog"};
        String order  ="khjzlicrmunogwbpqdetasyfvx";
        for(int i =0;i<order.length();i++){
            char_map[order.charAt(i)-'a']=i;
        }
       result= v.isAlienSorted(words, order);

      /* String[] words  ={"hello","leetcode"};

       result =  v.isAlienSorted(words, "hlabcdefgijkmnopqrstuvwxyz");*/

       System.out.println(result);
    }

    public boolean isAlienSorted(String[] words, String order) {

        for(int i =1;i<words.length;i++){
            int result = compare(words[i-1],words[i],order);
           // int result = compare("hellp", "hello", order);
            System.out.println(result);
            if(result>0) return false;
        }

        return true;
    }

    public int compare(String word1, String word2, String order) {
        int i = 0;
        int j = 0;
        int char_compare_val = 0;

        while (i < word1.length() && j < word2.length() && char_compare_val==0) {
            char char1 = word1.charAt(i);
            char char2 = word2.charAt(j);
            int indexOfWord1 = order.indexOf(char1);
            int indexOfWord2 = order.indexOf(char2);
            char_compare_val = indexOfWord1-indexOfWord2 ;
           // if(char_compare_val>0) return char_compare_val;
            i++;
            j++;
        }

        return char_compare_val ==0 ? word1.length()-word2.length():char_compare_val;
    }
}
