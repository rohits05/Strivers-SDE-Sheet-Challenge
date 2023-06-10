import java.io.*;
import java.util.*;

public class Solution {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        // Write your code here.
        int len1 = m - 1, len2 = n - 1;
        int temp = m + n - 1;
        while (len2 >= 0) {
            if (len1 >= 0 && arr1[len1] > arr2[len2])
                arr1[temp--] = arr1[len1--];
            else
                arr1[temp--] = arr2[len2--];
        }

        return arr1;
    }
}
