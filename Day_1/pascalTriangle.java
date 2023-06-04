import java.io.*;
import java.util.*;

import java.util.ArrayList;

public class Solution {
    public static ArrayList<ArrayList<Long>> printPascal(int n) {
        // Write your code here.
        ArrayList<ArrayList<Long>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Long> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    temp.add(new Long(1));
                else // just above guys!
                {
                    Long num = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
                    temp.add(num);
                }
            }
            res.add(temp);

        }
        return res;
    }
}
