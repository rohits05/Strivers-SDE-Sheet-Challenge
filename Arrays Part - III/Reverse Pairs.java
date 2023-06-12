import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static int reversePairs(ArrayList<Integer> arr) {
        // Write your code here.
        int len = arr.size(), cnt = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++)
                if (2 * arr.get(j) < arr.get(i))
                    cnt++;
        }

        return cnt;
    }
}