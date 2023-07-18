import java.util.*;
import java.io.*;

public class Solution {

    public static int editDistance(String s1, String s2) {
        // Your code goes here
        int n = s1.length(), m = s2.length();

        // int p[][] = new int[n+1][m+1];
        int p[] = new int[m + 1];
        for (int i = 1; i <= m; i++)
            p[i] = i;
        // for(int j=0; j<=m; j++) p[0][j] = j;

        for (int i = 1; i <= n; i++) {
            int c[] = new int[m + 1];
            c[0] = i;

            for (int j = 1; j <= m; j++) {
                int je = j - 1, ie = i - 1;
                if (s1.charAt(ie) == s2.charAt(je))
                    c[j] = p[je];
                else {
                    int ins = p[j], del = c[je];
                    int rep = p[je];
                    c[j] = 1 + Math.min(rep, Math.min(del, ins));
                }
            }
            p = c;
        }

        return p[m];
    }
}