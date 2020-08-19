package arrays;

import java.util.Arrays;

public class FindBestSeat {

    public static void main(String[] args) {
        int[] input = {1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1};
        //int[] input = {1,0,0,0,0,0,1};
        // System.out.println(findBestSeat(input));
        // System.out.println(findBestSeatConstantTimeApproach(input));
        System.out.println(findBestSeatOptimized(input));
    }

    /*
     *   1,1,1,1,0,0,0,1
     */
    public static int findBestSeatOptimized(int[] seats) {
        int i = 0, j = 1, maxDistance = 0, bestSeatIndex = -1;
        while (j < seats.length) {
            if (seats[j] != 0) {
                if (maxDistance < j - i) {
                    maxDistance = j - i;
                    bestSeatIndex = (i + j) / 2;

                }
                i = j;
            }
            j++;
        }
        return bestSeatIndex;
    }

    public static int findBestSeatConstantTimeApproach(int[] seats) {
        int i = 0, j = 0, maxDistance = Integer.MIN_VALUE, index = 0;
        boolean foundSeat = false;
        for (j = 0; j < seats.length; j++) {
            if (seats[j] == 0) {
                foundSeat = true;
                if (seats[j - 1] == 1) i = j - 1;
            } else {
                if (foundSeat) {
                    int currDistance = j - i;
                    if (maxDistance < currDistance) {
                        maxDistance = currDistance;
                        index = (i + j) / 2;
                    } else if (maxDistance == currDistance) {
                        index = Math.min(index, (i + j) / 2);
                    }

                }


                foundSeat = false;

            }
        }
        return index != 0 ? index : -1;
    }

    public static int findBestSeat(int[] seats) {
        int index = 0;
        int maxDistance = Integer.MIN_VALUE;
        int rightDistance = 0;
        int leftDistance = 0;

        int[] result = new int[seats.length - 2];
        int end = result.length - 1;
        Arrays.fill(result, 1);
        for (int start = 0; start < seats.length - 2 && end >= 0; start++) {
            if (seats[start + 1] == 0) {
                leftDistance++;
            } else {
                leftDistance = -1;
            }
            if (seats[end + 1] == 0) {
                rightDistance++;
            } else {
                rightDistance = -1;
            }


            result[start] = result[start] != -1 ? result[start] * leftDistance : -1;
            result[end] = result[end] != -1 ? result[end] * rightDistance : -1;
            end--;


        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] != -1) {
                if (maxDistance < result[i]) {
                    maxDistance = result[i];
                    index = i;
                } else if (maxDistance == result[i]) {
                    index = Math.min(index, i);
                }

            }
        }
        return index == 0 ? -1 : index + 1;
    }
}
