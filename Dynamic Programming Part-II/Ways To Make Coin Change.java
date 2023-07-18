import java.util.*;
import java.io.*;

public class Solution {

    public static long countWaysToMakeChange(int denominations[], int value) {
        // write your code here
        int n = denominations.length;
        long dp[][] = new long[n][value + 1];

        for (int i = 0; i < n; i++)
            dp[i][0] = 1;
        for (int i = 1; i < value + 1; i++)
            if (i % denominations[0] == 0)
                dp[0][i] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < value + 1; j++) {
                if (denominations[i] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - denominations[i]];
            }
        }

        return dp[n - 1][value];
    }
}