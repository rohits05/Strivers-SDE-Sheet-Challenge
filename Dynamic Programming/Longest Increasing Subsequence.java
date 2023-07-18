import java.util.*;
import java.io.*;

public class Solution {

    public static int longestIncreasingSubsequence(int a[]) {
        // Your code goes here
        int dp[] = new int[a.length];
        int len = 0;
        for (int num : a) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0)
                i = -(i + 1);

            dp[i] = num;
            if (i == len)
                len++;
        }

        return len;
    }

}