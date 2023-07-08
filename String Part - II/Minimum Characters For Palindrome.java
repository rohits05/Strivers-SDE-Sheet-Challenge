import java.util.*;
import java.io.*;

public class Solution {

    public static boolean isPalindrome(int st, int end, String str) {
        while (st < end)
            if (str.charAt(st++) != str.charAt(end--))
                return false;
        return true;
    }

    public static int minCharsforPalindrome(String str) {
        int n = str.length(), i = n - 1;
        while (i > 0) {
            if (str.charAt(i) == str.charAt(0)) {
                if (isPalindrome(0, i, str))
                    return n - 1 - i;
            }
            i--;
        }
        return n - 1;
    }
}