import java.util.*;
import java.io.*;

public class Solution {
    public static int cutLogs(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];

        for (int i = 0; i <= k; i++)
            for (int j = 0; j <= n; j++)
                dp[i][j] = -1;

        return memoization(k, n, dp);
    }

    public static int memoization(int eggs, int logs, int[][] dp) {
        // Base cases
        if (logs <= 1 || eggs == 1)
            return logs;
        if (dp[eggs][logs] != -1)
            return dp[eggs][logs];

        int ans = Integer.MAX_VALUE, start = 1, end = logs;
        while (start <= end) {
            int mid = (start + end) / 2;

            int br = memoization(eggs - 1, mid - 1, dp);
            int srv = memoization(eggs, logs - mid, dp);
            ans = Math.min(ans, 1 + Math.max(br, srv));

            if (br < srv)
                start = mid + 1;
            else
                end = mid - 1;
        }

        dp[eggs][logs] = ans;
        return ans;
    }
}
