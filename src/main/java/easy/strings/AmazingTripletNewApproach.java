package easy.strings;

public class AmazingTripletNewApproach {
    public static void main (String args[]){

    }
    public int[] findTriplets(int input[]){
        int maxSum = 0;
        int currentSum =0;
        for(int i =0;i<input.length;i++){
            int firstVal = input [i];
            int triplet[] = new int[3];
            triplet[0] =firstVal;
            boolean isSecondVal = false;
            for(int j= i;j<input.length;j++){
                int secondVal = input[j];
                if(firstVal<secondVal){
                    if(!isSecondVal){
                        triplet[1]=secondVal;
                        currentSum= firstVal+secondVal;
                        isSecondVal = true;
                    } else {
                        currentSum = currentSum + secondVal;
                        //triplet[];
                    }

                }
            }
        }
        return new int[2];
    }
}
