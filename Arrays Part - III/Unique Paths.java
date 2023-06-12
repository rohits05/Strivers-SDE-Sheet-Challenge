import java.util.*;
import java.io.*;

public class Solution {
    public static int uniquePaths(int m, int n) {
        // Write your code here.
        // Tabulation! TC: O(MxN) | SC: O(MxN)
        int dp[][] = new int[m][n]; 
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = 1; // Base case
                else {
                    int up = 0, left = 0; // bottom - up movement !
                    // checks for valid moves
                    if (i > 0)
                        up = dp[i - 1][j];
                    if (j > 0)
                        left = dp[i][j - 1];

                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
