import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static int maximumProfit(ArrayList<Integer> prices) {
        // Write your code here.
        int minI = prices.get(0), profit = 0;

        for (int i = 1; i < prices.size(); i++) {
            int cost = prices.get(i) - minI;
            profit = Math.max(cost, profit);
            minI = Math.min(minI, prices.get(i)); // update to new stocks
        }

        return profit;
    }
}