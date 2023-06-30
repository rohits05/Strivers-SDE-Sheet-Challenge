import java.util.*;
import java.io.*;

public class Solution {
    public static int jobScheduling(int[][] jobs) {
        // Write your code here
        int n = jobs.length, m = jobs[0].length, ans = 0;
        boolean res[] = new boolean[n];

        Arrays.sort(jobs, (a, b) -> (b[1] - a[1]));
        for (int i = 0; i < n; i++) {
            int j;
            for (j = Math.min(jobs[i][0] - 1, n - 1); j >= 0; j--) {
                if (res[j] == false) {
                    res[j] = true;
                    ans += jobs[i][1];
                    break;
                }
            }
        }
        return ans;
    }
}
