package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberMnemonics {
    private static Map<Character, String> digitLetterMapping = new HashMap<>();

    {
        digitLetterMapping.put('0', "");
        digitLetterMapping.put('1', "");
        digitLetterMapping.put('2', "abc");
        digitLetterMapping.put('3', "def");
        digitLetterMapping.put('4', "ghi");
        digitLetterMapping.put('5', "jkl");
        digitLetterMapping.put('6', "mno");
        digitLetterMapping.put('7', "pqrs");
        digitLetterMapping.put('8', "tuv");
        digitLetterMapping.put('9', "wxyz");

    }


    public static void main(String[] args) {
        PhoneNumberMnemonics pm = new PhoneNumberMnemonics();
        List result = pm.letterCombinations("23");
        printList(result);
    }

    public static void printList(List list) {
        for (Object item : list) {
            System.out.print(item + " ");
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> mnemonics = new ArrayList<>();
        exploreCombinations(0, new StringBuilder(), digits, mnemonics);
        return mnemonics;

    }

    private void exploreCombinations(
            int currentDigit,
            StringBuilder partialMnemonic,
            String digits,
            List<String> mnemonics
    ) {
        if (currentDigit == digits.length()) {
            mnemonics.add(partialMnemonic.toString());
            return;
        }

        char digitCharacter = digits.charAt(currentDigit);


        String letters = digitLetterMapping.get(digitCharacter);

        for (char possibleLetter : letters.toCharArray()) {
            // 1.) Choose - Append the letter that this digit can materialize into
            partialMnemonic.append(possibleLetter);

            // 2.) Explore - Recurse on the decision with changed state. We advance the digit we are working on.
            exploreCombinations(currentDigit + 1, partialMnemonic, digits, mnemonics);

            // 3.) Unchoose - We have returned to this stack frame of choice. Remove the choice, next loop will choose again.
            partialMnemonic.deleteCharAt(partialMnemonic.length() - 1);
        }
    }
}
