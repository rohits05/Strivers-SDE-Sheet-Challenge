import java.util.*;
import java.io.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
        // Write your code here..
        Arrays.sort(arr);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        func(0, arr, new ArrayList<>(), ans);
        return ans;
    }

    static void func(int ind, int nums[], ArrayList<Integer> d, ArrayList<ArrayList<Integer>> ans) {
        ans.add(new ArrayList<>(d));
        for (int i = ind; i < nums.length; i++) {
            if (i != ind && nums[i] == nums[i - 1])
                continue;
            d.add(nums[i]);
            func(i + 1, nums, d, ans);
            d.remove(d.size() - 1);
        }
    }
}