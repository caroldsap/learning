package fb;

public class ReverseMakeEqual {


    // Add any helper functions you may need here


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    public static void main(String[] args) {
        new ReverseMakeEqual().run();
    }

    boolean areTheyEqual(int[] target, int[] arr) {
        // Write your code here
        int pointerA = 0;
        int pointerB = 0;

        while (pointerA < target.length && pointerB < target.length) {

            if (target[pointerA] == arr[pointerB]) {
                if (pointerA != pointerB) {

                    int temp = arr[pointerA];
                    arr[pointerA] = arr[pointerB];
                    arr[pointerB] = temp;
                    pointerA++;
                    pointerB = pointerA;
                } else {

                    pointerA++;
                    pointerB++;
                }

            } else if (pointerB == target.length - 1 && target[pointerA] != arr[pointerB]) {
                return false;
            } else {
                pointerB++;

            }

        }
        return true;
    }

    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printString(String str) {
        System.out.print("[" + str + "]");
    }

    public void run() {
        int[] array_a_1 = {1, 2, 3, 4};
        int[] array_b_1 = {1, 4, 3, 2};
        boolean expected_1 = true;
        boolean output_1 = areTheyEqual(array_a_1, array_b_1);
        check(expected_1, output_1);

        int[] array_a_2 = {1, 2, 3, 4};
        int[] array_b_2 = {1, 4, 3, 3};
        boolean expected_2 = false;
        boolean output_2 = areTheyEqual(array_a_2, array_b_2);
        check(expected_2, output_2);
        // Add your own test cases here

    }
}

