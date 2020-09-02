package recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String args[]){
        Permutations p = new Permutations();
        List<String> combinations = p.printAllCombinations("AAB");
    }
    public  List<String> printAllCombinations(String input){
        if (input.length() == 0) {
            return new ArrayList<>();
        }

        List<String> permutations = new ArrayList<>();
        char[] buffer = new char[input.length()];
        exploreCombinations(0, buffer, 0,input, permutations);
        return permutations;
    }
    private void exploreCombinations(int startIndex,
                                    char[] buffer, int bufferIndex,
                                     String input,List<String > permutations){

        if(bufferIndex == input.length()){
            permutations.add(new String(buffer));
            return;
        }

        //for (char c : input.toCharArray()) {
        for(int i =startIndex;i<input.length();i++){
           // combination.append(input.charAt(i));
            buffer[bufferIndex] = input.charAt(i);
            exploreCombinations(startIndex + 1
                    ,buffer,bufferIndex+1, input, permutations);
           // combination.deleteCharAt(combination.length() - 1);
        }
    }
}
