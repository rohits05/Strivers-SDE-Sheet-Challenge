import java.io.*;
import java.util.List;
import java.util.*;

public class Solution {
    private static final int d = 256;
    private static final int q = 101;

    public static List<Integer> stringMatch(String txt, String pat) {
        List<Integer> res = new ArrayList<>();
        if (pat.length() > txt.length())
            return res;

        int i, j, p = 0, t = 0;
        int h = 1;

        for (i = 0; i < pat.length() - 1; i++)
            h = (h * d) % q;
        for (i = 0; i < pat.length(); i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        for (i = 0; i <= txt.length() - pat.length(); i++) {
            if (p == t) {
                for (j = 0; j < pat.length(); j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }
                if (j == pat.length())
                    res.add(i + 1);
            }
            if (i < txt.length() - pat.length()) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + pat.length())) % q;
                if (t < 0)
                    t = t + q;
            }
        }

        return res;
    }
}