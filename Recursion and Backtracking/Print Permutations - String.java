import java.util.*;
import java.io.*;

public class Solution {
    public static void helper(String input, String soFar, List<String> ans) {
        int n = input.length();
        if (n == 0) {
            ans.add(soFar);
            return;
        }

        for (int i = 0; i < n; i++) {
            char ch = input.charAt(i);
            String leftPart = input.substring(0, i);
            String rightpart = input.substring(i + 1);
            helper(leftPart + rightpart, ch + soFar, ans);
        }
    }

    public static List<String> findPermutations(String s) {
        List<String> ans = new ArrayList<String>();
        helper(s, "", ans);
        return ans;
    }
}