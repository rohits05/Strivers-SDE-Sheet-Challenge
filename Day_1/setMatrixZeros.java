import java.io.*;
import java.util.*;

public class Solution {
    public static void setZeros(int matrix[][]) {
        // Write your code here..
        int n = matrix.length, m = matrix[0].length;
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        for (int i = 0; i < n; i++) { // Specific r & c with 0's
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int r : row) {
            for (int j = 0; j < m; j++)
                matrix[r][j] = 0; // Setting that row as 0!
        }

        for (int c : col) {
            for (int i = 0; i < n; i++)
                matrix[i][c] = 0; // Setting that col as 0!
        }
    }

}