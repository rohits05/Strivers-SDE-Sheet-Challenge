import java.io.*;
import java.util.*;

import java.util.ArrayList;

public class Solution {
    public static int subarraysXor(ArrayList<Integer> arr, int x) {
        // Write your code here.
        int cnt = 0, temp = 0, n = arr.size();
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);

        for (int i = 0; i < n; i++) {
            cnt ^= arr.get(i);

            int xo = cnt ^ x;
            if (mp.containsKey(xo))
                temp += mp.get(xo);
            mp.put(cnt, mp.getOrDefault(cnt, 0) + 1);
        }

        return temp;
    }
}