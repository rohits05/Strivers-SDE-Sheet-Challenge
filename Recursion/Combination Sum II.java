import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        Collections.sort(arr);
        func(0, arr, target, ans, temp);
        return ans;
    }

    public static void func(int idx, ArrayList<Integer> arr, int t, ArrayList<ArrayList<Integer>> ans,
            ArrayList<Integer> d) {
        if (t == 0) {
            ans.add(new ArrayList<>(d));
            return;
        }

        int n = arr.size();
        for (int i = idx; i < n; i++) {
            if (i > idx && arr.get(i) == arr.get(i - 1))
                continue;
            if (arr.get(i) > t)
                break;
            d.add(arr.get(i));
            func(i + 1, arr, t - arr.get(i), ans, d);
            d.remove(d.size() - 1);
        }
    }
}