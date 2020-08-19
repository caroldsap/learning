package easy.strings;

import java.util.*;

public class GroupAnagrams {
    public static void main(String args[]){
    GroupAnagrams ga = new GroupAnagrams();
    ga.groupAnagrams(new String[]{"eat", "bat", "ate", "tab", "tea", "eat"});
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List> words = new HashMap<String,List>();
        List wordsList = null;
        for(String str:strs){
           // words.put(str,sortWord(str));
            String sortedWord = sortWord(str);
            if(words.containsKey(sortedWord)){
                wordsList = words.get(sortedWord);

            } else {
                wordsList = new ArrayList();

            }
            wordsList.add(str);
            words.put(sortedWord,wordsList);

        }
        if(!words.isEmpty()){
            List result = new ArrayList();
            for(List anagarams:words.values()){
                result.add(anagarams);
            }
            return result;
        }
        return null;
    }
    private String sortWord(String word){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
