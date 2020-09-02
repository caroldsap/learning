package sorting;

import static sorting.MergeSort.print;
import static sorting.MergeSort.split;

public class MergeSortMyApproach {

    private static int listToSort[] = new int[] {5, 3, 8, 6, 1, 10, 9, 2, 7, 4,11};

    public static void main(String[] args) {
        print(listToSort);
        mergeSort(listToSort);
    }
    public static void mergeSort(int[] listToSort) {
        if(listToSort.length ==1 ) return;
        //Split the listToSort into two halves

        int midIndex = listToSort.length/2;

        int[] firstHalf = new int[midIndex];
        int[] secondHalf = new int[listToSort.length-midIndex];
        split(listToSort, firstHalf, secondHalf);
        mergeSort(firstHalf);
        mergeSort(secondHalf);
        merge(listToSort, firstHalf, secondHalf);
        print(listToSort);
    }

    public static void merge(int[] listToSort, int[] firstHalf,int[] secondHalf){
        int mergeIndex = 0;
        int firstHalfIndex = 0;
        int secondHalfIndex = 0;
        while(firstHalfIndex<firstHalf.length || secondHalfIndex<secondHalf.length){
            int firstVal = firstHalfIndex<firstHalf.length?firstHalf[firstHalfIndex]:Integer.MAX_VALUE;
            int secondVal = secondHalfIndex<secondHalf.length?secondHalf[secondHalfIndex]:Integer.MAX_VALUE;

            if(firstVal>secondVal){
                listToSort[mergeIndex]=secondVal;
                mergeIndex++;
                secondHalfIndex++;
            } else{
                listToSort[mergeIndex]=firstVal;
                mergeIndex++;
                firstHalfIndex++;
            }
        }
    }

}
