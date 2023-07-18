import java.util.*;
import java.io.*;

public class Solution {
    private static int func(String s, int i, int j, int[][] dp) {
        if (i >= j)
            return 0;
        if (isPalindrome(s, i, j))
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        int mini = Integer.MAX_VALUE;
        int right = 0, left = 0;

        for (int k = i; k <= j - 1; k++) {
            if (dp[i][k] != -1)
                left = dp[i][k];
            else {
                left = func(s, i, k, dp);
                dp[i][k] = left;
            }
            if (dp[k + 1][j] != -1)
                right = dp[k + 1][j];
            else {
                right = func(s, k + 1, j, dp);
                dp[k + 1][j] = right;
            }
            int temp = 1 + left + right;
            mini = Math.min(temp, mini);
        }

        dp[i][j] = mini;
        return mini;
    }

    public static int palindromePartitioning(String str) {
        int[][] dp = new int[str.length()][str.length()];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return func(str, 0, str.length() - 1, dp);
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else
                return false;
        }

        return true;
    }
}
