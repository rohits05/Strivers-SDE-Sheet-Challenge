import java.io.*;
import java.util.*;

import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) {
        // Write your code here.
        int n = arr.size(), a = n / 3;
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int temp = arr.get(i);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        for (int i : map.keySet())
            if (map.get(i) > a)
                res.add(i);
        return res;
    }
}