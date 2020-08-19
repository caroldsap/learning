package stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinimumRemoveToMakeValid {
public static void main (String args[]){
    MinimumRemoveToMakeValid minimumRemoveToMakeValid = new MinimumRemoveToMakeValid();
    System.out.println(minimumRemoveToMakeValid.minRemoveToMakeValid("leet(c)ode)"));
}
    public String minRemoveToMakeValid(String s) {
        int i = 0, n = s.length();
        Stack<Integer> indices = new Stack<>();
        boolean[] removed = new boolean[s.length()];

        while (i < n) {
            if (s.charAt(i) == '(') {
                indices.push(i);
            } else if (s.charAt(i) == ')') {
                if (indices.empty()) {
                    /* Remove the unpaired closing parentheses. */
                    removed[i] = true;
                } else {
                    indices.pop();
                }
            }
            i++;
        }

        /* Remove the unpaired opening parentheses. */
        while (!indices.empty()) {
            removed[indices.firstElement()] = true;
            indices.pop();
        }

        String modified = "";
        for (int j = 0; j < n; j++) {
            if (!removed[j]) {
                modified += s.charAt(j);
            }
        }
        return modified;
    }

}
