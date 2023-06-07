import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // Write your code here
        HashMap<Integer, Boolean> map = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr.get(i)))
                res[1] = arr.get(i);
            else
                map.put(arr.get(i), true);
        }

        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(i)) {
                res[0] = i;
                break;
            }
        }

        return res;
    }
}