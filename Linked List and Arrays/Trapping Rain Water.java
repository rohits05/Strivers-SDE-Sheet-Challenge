import java.util.*;
import java.io.*;

public class Solution {
    public static long getTrappedWater(long[] arr, int n) {
        // Write your code here.
        if (n <= 2)
            return 0;
        long maxleft = Integer.MIN_VALUE, maxright = Integer.MIN_VALUE;
        int low = 0, high = n - 1;
        long ans = 0;

        while (low <= high) {
            if (arr[low] <= arr[high]) {
                if (arr[low] >= maxleft)
                    maxleft = arr[low];
                else
                    ans += maxleft - arr[low];
                low++;
            }

            else {
                if (arr[high] >= maxright)
                    maxright = arr[high];
                else
                    ans += maxright - arr[high];
                high--;
            }
        }

        return ans;
    }
}
