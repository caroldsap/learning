package recursion;

public class PrintAllCombinations {

    public static void main (String args[]){
        int input[] = {0,1,2,3};
        printCombos(input,3);
    }
    public static void printCombos(int[] a, int x) {
        if (a == null || a.length == 0 || a.length < x) {
            return;
        }
        int[] buffer = new int[x];
        printCombosHelper(a, buffer, 0, 0);
    }

    public static void printCombosHelper(int[] a, int[] buffer, int startIndex, int bufferIndex) {
        if (bufferIndex == buffer.length) {
            printArray(buffer);
            return;
        }
        if (startIndex == a.length) {
            return;
        }

        for ( int i = startIndex;i<a.length;i++){
            buffer[bufferIndex] = a[i];
            printCombosHelper(a,buffer,i +1,bufferIndex +1);
        }
    }

    private static void printArray(int[] buffer) {
        System.out.println();
        for ( int b:buffer){
            System.out.print(b+" ");
        }
    }
}
