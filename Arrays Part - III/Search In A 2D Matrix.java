import java.util.ArrayList;

public class Solution {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        // Write your code here.
        if (mat == null || mat.isEmpty() || mat.get(0).isEmpty())
            return false;

        int rows = mat.size(), cols = mat.get(0).size();
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = mat.get(mid / cols).get(mid % cols);

            if (midValue == target)
                return true;
            else if (midValue < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return false;
    }
}
