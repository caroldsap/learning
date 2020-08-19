package easy.hashset;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class JewelsIntoStones {
    public static void main (String args[]) {
    System.out.println(numJewelsInStones("aA","aAAbbb"));
    }
    public static int numJewelsInStones(String J, String S) {
        Set jewels = new HashSet();
        for(char j:J.toCharArray()){
            jewels.add(j);
        }
        int count = 0;
        for(char stones:S.toCharArray()){
            if(jewels.contains(stones)){
                count++;
            }
        }
        return count;
    }
}
