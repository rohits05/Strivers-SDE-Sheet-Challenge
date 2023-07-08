import java.util.*;
import java.io.*;

public class Solution {
    public static boolean areAnagram(String a, String b) {
        // Write your code here.
        int n = a.length(), m = b.length();

        if (n != m)
            return false;

        else {
            int cnt[] = new int[26];
            int len = cnt.length;
            for (int i = 0; i < n; i++)
                cnt[a.charAt(i) - 'a']++;
            for (int i = 0; i < m; i++)
                cnt[b.charAt(i) - 'a']--;

            for (int i = 0; i < len; i++)
                if (cnt[i] != 0)
                    return false;
        }

        return true;
    }
}