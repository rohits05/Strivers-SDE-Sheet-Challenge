import java.util.*;
import java.io.*;

public class Solution {

    public static int distinctSubstring(String word) {
        // Write your code here.
        Map<String, Integer> map = new HashMap<>();
        int n = word.length();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String substring = word.substring(i, j + 1);
                map.put(substring, map.getOrDefault(substring, 0) + 1);
            }
        }

        return map.size();
    }
}
