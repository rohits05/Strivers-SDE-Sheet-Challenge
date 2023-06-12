import java.io.*;
import java.util.*;

import java.util.ArrayList;

public class Solution {

    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
        // Write your code here.
        int n = arr.size();
        int sum = 0, temp = 0, maxI = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum += arr.get(i);
            if (mp.containsKey(sum))
                maxI = i - (mp.get(sum)); // p-sum likewise
            else
                mp.put(sum, i);
            if (sum == 0)
                maxI = i + 1;
            temp = Math.max(temp, maxI);
        }

        return temp;
    }
}