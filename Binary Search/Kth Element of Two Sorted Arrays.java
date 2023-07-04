public class Solution {
    public static int ninjaAndLadoos(int row1[], int row2[], int m, int n, int k) {
        // Write your code here.
        if (n < m)
            return ninjaAndLadoos(row2, row1, n, m, k);
        int low = Math.max(0, k - n), high = Math.min(k, m);

        while (low <= high) {
            int cut1 = (low + high) >> 1, cut2 = k - cut1;
            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : row1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : row2[cut2 - 1];
            int r1 = (cut1 == m) ? Integer.MAX_VALUE : row1[cut1];
            int r2 = (cut2 == n) ? Integer.MAX_VALUE : row2[cut2];

            if (l1 <= r2 && l2 <= r1)
                return Math.max(l1, l2);
            else if (l1 > r2)
                high = cut1 - 1;
            else
                low = cut1 + 1;
        }
        return 1;
    }
}
