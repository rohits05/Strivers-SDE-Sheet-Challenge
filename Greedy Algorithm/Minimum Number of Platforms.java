import java.util.*;
import java.io.*;

public class Solution {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        // Write your code here.
        Arrays.sort(at);
        Arrays.sort(dt);

        int i = 0, j = 0, cnt = 0, ans = 0;
        while (i < n) {
            if (at[i] <= dt[j]) {
                cnt++;
                ans = Math.max(ans, cnt);
                i++;
            } else if (at[i] > dt[j]) {
                cnt--;
                j++;
            }
        }

        return ans;
    }
}