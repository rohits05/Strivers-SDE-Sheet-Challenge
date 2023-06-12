import java.io.*;
import java.util.*;

public class Solution {
    public static int findMajority(int[] arr, int n) {
        // Write your code here.
        int el = -1, cnt = 0;

        for (int i : arr) {
            if (cnt == 0)
                el = i;
            if (el == i)
                cnt += 1;
            else
                cnt -= 1;
        }
        cnt = 0;

        for (int i = 0; i < n; i++)
            if (el == arr[i])
                cnt++;
        return cnt > n / 2 ? el : -1; // Ternary case, if nF then -1
    }
}