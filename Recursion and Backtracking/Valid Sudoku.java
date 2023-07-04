import java.util.*;
import java.io.*;

public class Solution {

    public static boolean isItSudoku(int matrix[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (valid(i, j, k, matrix) == true) {
                            matrix[i][j] = k;
                            if (isItSudoku(matrix) == true)
                                return true;
                            else
                                matrix[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean valid(int i, int j, int k, int[][] matrix) {
        for (int l = 0; l < 9; l++) {
            if (matrix[l][j] == k)
                return false;
            if (matrix[i][l] == k)
                return false;
            if (matrix[3 * (i / 3) + i / 3][3 * (j / 3) + i % 3] == k)
                return false;
        }

        return true;
    }
}
