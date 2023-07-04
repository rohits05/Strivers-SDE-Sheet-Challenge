public class Solution {
    public static int search(int nums[], int key) {
        // Write your code here.
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key <= nums[end] && nums[mid] > nums[end])
                start = mid + 1;
            else if (key > nums[end] && nums[mid] < nums[end])
                end = mid - 1;
            else {
                if (nums[mid] == key)
                    return mid;
                else if (key < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }

        return -1;
    }
}