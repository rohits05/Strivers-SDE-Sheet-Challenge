import java.util.*;
import java.io.*;

public class Solution {
    public static int matrixMultiplication(int[] arr, int N) {
        // Write your code here
        int dp[][] = new int[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(dp[i], -1);

        return mcm(arr, 1, N - 1, dp);
    }

    private static int mcm(int arr[], int i, int j, int dp[][]) {
        if (i == j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {

            int cost1 = mcm(arr, i, k, dp), cost2 = mcm(arr, k + 1, j, dp);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int finalcost = cost1 + cost2 + cost3;
            ans = Math.min(finalcost, ans);
        }

        return dp[i][j] = ans;
    }
}
