import java.util.*;
import java.io.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        combo(arr, new ArrayList<>(), 0, res, k);
        return res;
    }

    static void combo(ArrayList<Integer> ar, ArrayList<Integer> ds, int idx, ArrayList<ArrayList<Integer>> res, int k) {
        if (k == 0)
            res.add(new ArrayList<>(ds));
        if (idx == ar.size())
            return;

        for (int i = idx; i < ar.size(); i++) {
            ds.add(ar.get(i));
            combo(ar, ds, i + 1, res, k - ar.get(i));
            ds.remove(ds.size() - 1);
        }
    }
}