import java.io.*;
import java.util.*;

public class Solution {
    public static List<int[]> pairSum(int[] arr, int s) {
        // Write your code here.
        int n = arr.length;
        List<int[]> res = new ArrayList<>();

        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i : arr) {
            if (mp.containsKey(s - i)) {
                int temp = mp.get(s - i);
                while (temp-- > 0)
                    res.add(new int[] { Math.min(i, s - i), Math.max(i, s - i) });
            }
            mp.put(i, mp.getOrDefault(i, 0) + 1); // Curr val & idx
        }

        Collections.sort(res, Comparator.comparingInt(a -> a[0]));
        return res;
    }
}
