import java.util.*;
import java.io.*;

public class Solution {

    public static int lcs(String s1, String s2) {
        // Your code goes here
        int m = s1.length(), n = s2.length();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int[] curr = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    curr[j] = 1 + dp[j - 1];
                else
                    curr[j] = Math.max(dp[j], curr[j - 1]);
            }
            dp = curr;
        }

        return dp[n];
    }
}