public class Solution {
    public static int NthRoot(int n, int m) {
        // Write your code here.
        int strt = 1, end = m;

        while (strt <= end) {
            int mid = (strt + end) / 2;
            int temp = (int) Math.pow(mid, n);
            if (temp == m)
                return mid;
            else if (temp > m)
                end = mid - 1;
            else
                strt = mid + 1;
        }

        return -1;
    }
}
