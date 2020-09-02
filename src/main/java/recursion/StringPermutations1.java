package recursion;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class StringPermutations1 {


        public static void permutations(char[] array, int length, Set permutations) {
            if (length == 1) {
                permutations.add(new String(array));
                //System.out.println(array);
                return;
            }
            else {
                for (int i = 0; i < length; i++) {
                    swap(array, i, length-1);
                    permutations(array, length-1,permutations);
                    swap(array, i, length-1);
                }
            }
        }

        public static void swap(char[] array, int i, int j) {
            char c;
            c = array[i];
            array[i] = array[j];
            array[j] = c;
        }

        public static void main( String args[] ) {
            char[] input = {'a', 'b', 'c'};
            Set permutations = new TreeSet();
            permutations(input, input.length,permutations);
            permutations.forEach(s->System.out.println(s));
        }

}
