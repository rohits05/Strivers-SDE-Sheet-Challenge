import java.util.*;
import java.io.*;

public class Solution {
    public static String check(String s, int left, int right) {
        int n = s.length();
        while (left >= 0 && right < n) {
            if (s.charAt(left) != s.charAt(right))
                break;
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static String longestPalinSubstring(String str) {
        String longest = "";
        int n = str.length();
        for (int i = 0; i < n; i++) {
            String odd = check(str, i, i);
            if (odd.length() > longest.length())
                longest = odd;
        }

        for (int i = 0; i < n; i++) {
            String even = check(str, i, i + 1);
            if (even.length() > longest.length())
                longest = even;
        }

        return longest;
    }
}
