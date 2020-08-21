package arrays.twodimensional;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},{5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(matrix.length + " " + matrix[0].length);
        rotate(matrix);
        //  System.out.println();
    }

    public  static void rotate(int[][] matrix) {
        int rowLen = matrix.length;
        int columnLen = matrix[0].length;
        //Transpose
        for (int i = 0; i < rowLen-1; i++) {
            for (int j = i; j < columnLen; j++) {
                int temp1 = matrix[i][j];
                int temp2 = matrix[j][i];
                matrix[i][j] = temp2;
                matrix[j][i] = temp1;
            }
        }
        //Reverse

        for (int i = 0; i < rowLen; i++) {
            int endCol = columnLen-1;
                for(int startCol=0;startCol<(columnLen/2);startCol++){

                    int temp1 = matrix[i][startCol];
                    int temp2 = matrix[i][endCol];
                    matrix[i][startCol] = temp2;
                    matrix[i][endCol] = temp1;
                    //startCol++;
                    //endCol--;
                    endCol--;
                }
                //endCol--;
        }
        //System.out.println(matrix);
    }

}
