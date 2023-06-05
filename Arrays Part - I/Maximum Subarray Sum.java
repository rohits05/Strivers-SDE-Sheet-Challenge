import java.util.*;
import java.io.*;

public class Solution {

    public static long maxSubarraySum(int[] nums, int n) {
        // write your code here
        long sum = 0, maxi = nums[0];
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            maxi = Math.max(maxi, sum);
            if (maxi < 0)
                maxi = 0;
            if (sum < 0)
                sum = 0;
        }
        return maxi;
    }
}
