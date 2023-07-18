import java.util.*;
import java.io.*;

public class Solution {

    public static int cutRod(int price[], int n) {
        // Write your code here.
        int m = price.length;
        int np[] = new int[m + 1];

        for (int i = 0; i < m; i++)
            np[i + 1] = price[i];
        int dp[] = new int[m + 1];
        dp[0] = 0;
        dp[1] = np[1];

        for (int i = 2; i <= m; i++) {
            dp[i] = np[i];
            int li = 1, ri = i - 1;
            while (li <= ri) {
                if (dp[li] + dp[ri] > dp[i])
                    dp[i] = dp[li] + dp[ri];
                li++;
                ri--;
            }
        }

        return dp[m];
    }
}