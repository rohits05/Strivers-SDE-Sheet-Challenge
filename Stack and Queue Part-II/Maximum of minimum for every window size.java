import java.util.*;
import java.io.*;

public class Solution {
    public static int[] maxMinWindow(int[] a, int n) {
        // Write your code here
        int[] nse = new int[n];
        int[] pse = new int[n];
        int[] res = new int[n];
        Arrays.fill(res, Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            pse[i] = i;
            nse[i] = n - i - 1;
        }

        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stk.empty() && a[stk.peek()] > a[i]) {
                nse[stk.peek()] = i - stk.peek() - 1;
                stk.pop();
            }
            stk.push(i);
        }

        while (!stk.empty()) {
            stk.pop();
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!stk.empty() && a[stk.peek()] > a[i]) {
                pse[stk.peek()] = stk.peek() - i - 1;
                stk.pop();
            }
            stk.push(i);
        }

        for (int i = 0; i < n; i++) {
            int d = nse[i] + pse[i];
            res[d] = Math.max(res[d], a[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            if (res[i] < res[i + 1]) {
                res[i] = res[i + 1];
            }
        }

        return res;
    }
}
