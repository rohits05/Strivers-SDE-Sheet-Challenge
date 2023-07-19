import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Solution {
    public static int singleNonDuplicate(ArrayList<Integer> arr) {
        // Write your code here.
        int len = arr.size(), low = 0, high = len - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid % 2 == 1) {
                int firstmid = arr.get(mid), lastmid = arr.get(mid - 1);

                if (firstmid == lastmid)
                    low = mid + 1;
                else
                    high = mid;
            } else if (mid % 2 == 0) {
                int nextmid = arr.get(mid), nextLmid = arr.get(mid + 1);

                if (nextmid == nextLmid)
                    low = mid + 1;
                else
                    high = mid;
            }
        }

        return arr.get(low);
    }
}
