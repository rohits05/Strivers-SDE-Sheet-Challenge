import java.util.*;
import java.io.*;

public class Solution {

    public static ArrayList<ArrayList<Integer>> findTriplets(int[] nums, int n, int K) {

        // Write your code here.
        Set<ArrayList<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1, k = n - 1;
            int target = K - nums[i];
            while (j < k) {
                if ((nums[j] + nums[k]) < target)
                    j++;
                else if ((nums[j] + nums[k]) > target)
                    k--;
                else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    set.add(temp);
                    j++;
                }
            }
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
}
