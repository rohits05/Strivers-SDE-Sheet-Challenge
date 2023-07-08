import java.util.*;
import java.io.*;

public class Solution {
    public static int compareVersions(String a, String b) {
        // Write your code here
        String[] arr1 = a.split("[.]");
        String[] arr2 = b.split("[.]");
        int a1 = arr1.length, a2 = arr2.length;

        int len = (a1 > a2) ? a1 : a2;
        int i = 0;

        double val1 = 0, val2 = 0;
        while (i < len) {
            val1 = (i < a1) ? Double.valueOf(arr1[i]) : 0;
            val2 = (i < a2) ? Double.valueOf(arr2[i]) : 0;
            if (val1 > val2)
                return 1;
            else if (val1 == val2)
                i++;
            else
                return -1;
        }

        return 0;
    }
}