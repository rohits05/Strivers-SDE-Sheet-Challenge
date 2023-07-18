import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static int maximumProduct(ArrayList<Integer> nums, int n) {
        // Write your code here.
        int maxP = nums.get(0), minP = nums.get(0), ans = nums.get(0);

        for (int i = 1; i < n; i++) {
            int first = nums.get(i);
            int second = maxP * nums.get(i);
            int third = minP * nums.get(i);

            minP = Math.min(Math.min(first, second), third);
            maxP = Math.max(Math.max(first, second), third);
            ans = Math.max(ans, maxP);
        }

        return ans;
    }
}