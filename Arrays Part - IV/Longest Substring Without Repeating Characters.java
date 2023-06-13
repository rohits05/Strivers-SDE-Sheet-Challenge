import java.util.*;
import java.io.*;

public class Solution {
    public static int uniqueSubstrings(String input) {
        // write your code here
        HashMap<Character, Integer> mp = new HashMap<Character, Integer>();

        int res = 0, n = input.length();
        for (int i = 0, j = 0; i < n; i++) {
            if (mp.containsKey(input.charAt(i)))
                j = Math.max(j, mp.get(input.charAt(i)) + 1);
            mp.put(input.charAt(i), i);
            res = Math.max(res, i - j + 1);
        }

        return res;
    }
}
