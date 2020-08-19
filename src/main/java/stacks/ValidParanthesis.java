package stacks;

import java.util.HashMap;
import java.util.Stack;

public class ValidParanthesis {
    public static void main (String args[]){
    ValidParanthesis vp = new ValidParanthesis();
    System.out.println(vp.isValid("()"));

    }

    static HashMap<Character,Character> map = new HashMap<Character,Character>();
    {
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');

    }

    public boolean isValid(String s) {
        if(s == null || s.length() ==0 ) return true;
        if(s.length() == 1) return false;
        Stack<Character> characterStack = new Stack<>();
        for(char c: s.toCharArray()){
            if(map.containsValue(c)){
                characterStack.push(c);
                continue;
            }
            if (characterStack.size() == 0 || map.get(c) != characterStack.pop()) {
                return false;
            }

        }
        return characterStack.size()==0?true:false;
    }
}
