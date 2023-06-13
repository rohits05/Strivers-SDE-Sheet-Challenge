import java.io.*;
import java.util.*;

public class Solution {
    public static String fourSum(int[] nums, int target, int n) {
        // Write your code here.
        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                long temp = (long) target - (long) nums[i] - (long) nums[j];
                int k = j + 1, l = n - 1;
                while (k < l) {
                    long res = (long) nums[k] + (long) nums[l];
                    if (temp > res)
                        k++;
                    else if (temp < res)
                        l--;
                    else
                        return "Yes";
                }
            }
        }

        return "No";
    }
}
