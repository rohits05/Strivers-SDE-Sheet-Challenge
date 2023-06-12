import java.io.*;
import java.util.*;

public class Solution {
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        // Write your code here.
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int n : arr) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;

                int sum = left + right + 1;
                map.put(n, sum);

                res = Math.max(res, sum);
                map.put(n - left, sum);
                map.put(n + right, sum);
            } else
                continue;
        }

        return res;
    }
}