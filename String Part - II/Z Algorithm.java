import java.util.*;
import java.io.*;

public class Solution {

    public static int zAlgorithm(String s, String p, int n, int m) {
        // Write your code here
        int cnt = 0;

        for (int i = 0; i < n - m + 1; i++)
            if (s.charAt(i) == p.charAt(0))
                if (s.substring(i, m + i).equals(p))
                    cnt++;

        return cnt;
    }

}