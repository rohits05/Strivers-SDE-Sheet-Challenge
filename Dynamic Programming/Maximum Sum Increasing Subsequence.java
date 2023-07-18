import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static int maxIncreasingDumbbellsSum(ArrayList<Integer> arr, int n) {
        // Write your code here.
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++)
            set.add(arr.get(i));

        int m = set.size(), j = 0;
        int arr1[] = new int[m];
        for (int el : set) {
            arr1[j] = el;
            j++;
        }

        Arrays.sort(arr1);
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++)
            Arrays.fill(dp[i], 0);
        return solve(arr, arr1, n, m, dp);
    }

    public static int solve(ArrayList<Integer> a1, int a2[], int n, int m, int dp[][]) {

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (a1.get(i - 1) == a2[j - 1])
                    dp[i][j] = a1.get(i - 1) + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n][m];
    }
}