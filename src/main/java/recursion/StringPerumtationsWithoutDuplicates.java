package recursion;

import java.util.ArrayList;
import java.util.List;

public class StringPerumtationsWithoutDuplicates {


    public static void main(String args[]){
        StringPerumtationsWithoutDuplicates sd = new StringPerumtationsWithoutDuplicates();
        List<List<Character>> allPermutations = sd.permute("aab");
        allPermutations.forEach(s -> System.out.println(s));
    }
    /**
     *
     * @param input
     * @return
     */
    public List<List<Character>> permute(String input) {
        List<List<Character>> allPermutations = new ArrayList<>();
        generateAllPermutations(new ArrayList<>(), input.toCharArray(), allPermutations);

        return allPermutations;
    }

    /**
     *
     * @param runningChoices
     * @param input
     * @param allPermutations
     */
    private void generateAllPermutations(
            List<Character> runningChoices,
            char[] input,
            List<List<Character>> allPermutations
    ) {
        if (runningChoices.size() == input.length) {
            allPermutations.add(new ArrayList<Character>(runningChoices));
            return;
        }

    /*
      Every stack frame of this function call represents the expression of trying (almost) all items in every "slot" in the array.
      The recursion stops when we are choosing on 1 past the final "slot".
    */
        for (int i = 0; i < input.length; i++) {
            char choice = input[i];

            // Skip if element already exists in 'runningChoices'

            if (runningChoices.contains(choice)) {
                continue;
            }
            // 1.) Choose - Add the item to the 'runningChoices'
            runningChoices.add(choice);

            // 2.) Explore - Recurse on the choice
            generateAllPermutations(runningChoices, input, allPermutations);

            // 3.) Unchoose - We have returned from the recursion, remove the choice we made.
            // The next iteration will try another item in the "slot" we are working on.
            runningChoices.remove(runningChoices.size() - 1);
        }
    }
}

