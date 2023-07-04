import java.util.*;
import java.io.*;

public class Solution {
    public static double median(int[] a, int[] b) {
        // Write your code here.
        if (a.length > b.length)
            return median(b, a);
        int n1 = a.length, n2 = b.length;

        int low = 0, high = n1;
        while (low <= high) {
            int cnt1 = (high + low) / 2, cnt2 = ((n1 + n2 + 1) / 2) - cnt1;
            int l1 = cnt1 == 0 ? Integer.MIN_VALUE : a[cnt1 - 1];
            int l2 = cnt2 == 0 ? Integer.MIN_VALUE : b[cnt2 - 1];
            int r1 = cnt1 == n1 ? Integer.MAX_VALUE : a[cnt1];
            int r2 = cnt2 == n2 ? Integer.MAX_VALUE : b[cnt2];
            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0)
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                else
                    return Math.max(l1, l2) / 1.0;
            } else if (l1 > r2)
                high = cnt1 - 1;
            else
                low = cnt1 + 1;
        }
        return 0.0;
    }
}