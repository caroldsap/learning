package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



public class StairCaseClimbing {

    public static void main(String[] args) {
    int numberOfWays = numberOfWays("3");
    //System.out.println(numberOfWays);
    }

    private static int numberOfWays(String input) {

        List numberOfWays = new ArrayList();

        decodeWays(new int[]{1, 2}, Integer.parseInt(input), 0, new Stack<Integer>(),
                0, numberOfWays);
       /* decodeWays(new int[]{2, 1}, Integer.parseInt(input), 0, new Stack<Integer>(),
                0, numberOfWays);*/
       System.out.println(CountWays(Integer.parseInt(input)));
        return numberOfWays.size();
    }


    public static void decodeWays(int[] jumps, int target, int startIndex, Stack<Integer> buffer, int sum, List numberOfWays) {
        // termination cases
        if (sum > target) {
            return;
        }
        if (sum == target) {
           // print(buffer);
            numberOfWays.add(buffer);
            //System.out.println("\n");
            return;
        }
        for (int i = startIndex; i < jumps.length; i++) {
            buffer.push(jumps[i]);
            decodeWays(jumps, target, i, buffer, sum + jumps[i],numberOfWays);
            buffer.pop();
        }
    }
    private static void print(Stack stack){
        stack.forEach(s->System.out.print(s));
    }

    public static int CountWays(int n) {
        if( n == 0)
            return 1;

        if(n == 1)
            return 1; // we can take one step to reach the end, and that is the only way

        if(n == 2)
            return 2; // we can take one step twice or jump two steps to reach at the top

        // if we take 1 step, we are left with 'n-1' steps;
        int take1Step = CountWays(n-1);
        // similarly, if we took 2 steps, we are left with 'n-2' steps;
        int take2Step = CountWays(n-2);

        return take1Step + take2Step ;
    }
}
