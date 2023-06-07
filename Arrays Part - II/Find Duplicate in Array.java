import java.io.*;
import java.util.*;

import java.util.ArrayList;

public class Solution {
    public static int findDuplicate(ArrayList<Integer> arr, int n) {
        // Write your code here.
        int[] cnt = new int[n + 1];
        int len = cnt.length, res = -1;
        for (int items : arr)
            cnt[items]++;

        for (int i = 0; i < len; i++)
            if (cnt[i] > 1)
                return res = i;
        return res;
    }
}
