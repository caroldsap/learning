package easy.hashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueChar {

    public static void main (String args[]){

        System.out.println(firstUniqChar("leetcode"));
    }
    public static int firstUniqChar(String s) {
        Map<Character,Integer> chars = new LinkedHashMap();
        for(int i =0;i<s.length();i++){

               chars.put(s.charAt(i),chars.getOrDefault(s.charAt(i)-1,1));

        }
        if(!chars.isEmpty()){
            for(int index:chars.values()){
                if(index>=0){
                    return index;
                }
            }
        }
        return -1;
    }
}
