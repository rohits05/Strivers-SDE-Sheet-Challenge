import java.util.*;
import java.io.*;

public class Solution {
    public static boolean subsetSumToK(int N, int sum, int arr[]) {
        // Write your code here.
        boolean[] prev = new boolean[N + 1];
        Arrays.fill(prev, true);

        for (int i = 0; i < N + 1; i++) {
            boolean[] curr = new boolean[sum + 1];

            for (int j = 0; j < sum + 1; j++) {
                if ((i == 0 || i != 0) && j == 0)
                    curr[j] = true;
                else if (i == 0 && j != 0)
                    curr[j] = false;
                else if (arr[i - 1] <= j)
                    curr[j] = prev[j] || prev[j - arr[i - 1]];
                else
                    curr[j] = prev[j];
            }
            prev = curr;
        }

        return prev[sum];
    }

    public static boolean canPartition(int[] arr) {
        int N = arr.length, total = 0;
        for (int i = 0; i < N; i++)
            total += arr[i];
        if (total % 2 == 1)
            return false;

        int target = total / 2;
        return subsetSumToK(N, target, arr);
    }
}
