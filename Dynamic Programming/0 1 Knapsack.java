import java.util.ArrayList;

public class Solution {
    public static int maxProfit(ArrayList<Integer> val, ArrayList<Integer> wt, int n, int w) {
        // Write your code here.
        int prev[] = new int[w + 1];

        for (int i = 0; i <= w; i++)
            if (i >= wt.get(0))
                prev[i] = val.get(0);

        for (int i = 1; i < n; i++) {
            for (int j = w; j >= 0; j--) {
                int noT = prev[j], take = Integer.MIN_VALUE;

                if (j >= wt.get(i))
                    take = val.get(i) + prev[j - wt.get(i)];
                prev[j] = Math.max(noT, take);
            }
        }

        return prev[w];
    }
}