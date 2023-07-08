import java.util.*;
import java.io.*;

public class Solution {
    public static boolean findPattern(String p, String s) {
        int pS = p.length(), sS = s.length();
        int[] temp = new int[pS];
        computeLPS(p, temp, pS);
        int i = 0, j = 0;
        while (j < sS) {
            if (s.charAt(j) == p.charAt(i)) {
                i++;
                j++;
            }
            if (i == pS) {
                return true;
            } else if (j < sS && s.charAt(j) != p.charAt(i)) {
                if (i != 0) {
                    i = temp[i - 1];
                } else {
                    j++;
                }
            }
        }
        return false;
    }

    private static void computeLPS(String p, int[] temp, int pS) {
        temp[0] = 0;
        int i = 0, j = 1;
        while (j < pS) {
            if (p.charAt(i) == p.charAt(j)) {
                i++;
                temp[j] = i;
                j++;
            } else {
                if (i != 0) {
                    i = temp[i - 1];
                } else {
                    temp[j] = 0;
                    j++;
                }
            }
        }
    }
}