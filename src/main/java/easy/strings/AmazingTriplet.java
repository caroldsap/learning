package easy.strings;

import java.util.*;

public class AmazingTriplet {
    public static void main(String args[]){
    int[] input = new int[]{13,16,2,7,3,18,19,6,15,11,17};
    Map tripletsMap = findTriplets(input);
    for(Object key:tripletsMap.keySet()){
        int values[] = (int[]) tripletsMap.get(key);
        for (int v: values){
            System.out.print(v+" ");
        }
        System.out.println("");
    }
    //System.out.println(tripletSum(findTriplets(input)));

    }
    public static Map findTriplets(int input[]){
        Map triplets = new LinkedHashMap();
        for(int i =0;i<input.length;i++){
            int firstVal = input[i];
            int secondVal = 0;
            for(int j=i;j<input.length;j++){
                if(firstVal<input[j]){
                    if(triplets.containsKey(input[i])){
                        int[] array = (int[]) triplets.get(input[i]);
                        array[2] = input[j];
                        triplets.put(firstVal,array);
                    } else {
                        secondVal = input[j];
                        triplets.put(firstVal,new int[]{firstVal,secondVal,0});
                        firstVal = secondVal;
                    }

                }
            }
        }
        return triplets;
    }
    public static int findMaxTriplet(List triplets){
        return 0;
    }
}
