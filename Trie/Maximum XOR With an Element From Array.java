import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class Solution {
    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {
        // Write your code here.
        ArrayList<Integer> res = new ArrayList<>();

        for (ArrayList<Integer> query : queries) {
            int temp1 = query.get(1), temp2 = query.get(0);
            int maxI = -1;

            for (int num : arr)
                if (temp1 >= num)
                    maxI = Math.max(maxI, temp2 ^ num);
            res.add(maxI);
        }

        return res;
    }
}