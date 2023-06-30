import java.util.*;
import java.io.*;

public class Solution {
    public static int findMinimumCoins(int amount) {
        // Write your code here.
        int cnt = 0, i = 0;
        int temp[] = { 1000, 500, 100, 50, 20, 10, 5, 2, 1 };
        int n = temp.length;

        while (i < n) {
            if (amount >= temp[i]) {
                cnt += amount / temp[i];
                int calC = amount / temp[i];
                amount -= calC * temp[i];
            }
            i++;
        }

        return cnt;
    }
}
