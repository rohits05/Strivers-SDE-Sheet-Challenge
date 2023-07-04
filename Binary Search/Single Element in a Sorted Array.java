import java.util.ArrayList;

public class Solution {
    public static int singleNonDuplicate(ArrayList<Integer> nums) {
        // Write your code here.
        int start = 0, end = nums.size() - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            if ((mid % 2 == 0 && nums.get(mid) == nums.get(mid + 1)) ||
                    (mid % 2 == 1 && nums.get(mid) == nums.get(mid - 1)))
                start = mid + 1;
            else
                end = mid;
        }

        return nums.get(start);
    }
}