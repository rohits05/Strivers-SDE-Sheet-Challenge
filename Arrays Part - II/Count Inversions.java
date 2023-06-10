import java.util.*;
import java.io.*;

public class Solution {
    public static long getInversions(long arr[], int n) {
        long temp[] = new long[n];
        return mergeSort(arr, temp, 0, n - 1);
    }

    private static long mergeSort(long[] arr, long[] temp, int left, int right) {
        long inv = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            inv += mergeSort(arr, temp, left, mid);
            inv += mergeSort(arr, temp, mid + 1, right);
            inv += merge(arr, temp, left, mid + 1, right);
        }

        return inv;
    }

    private static long merge(long[] arr, long[] temp, int left, int mid, int right) {
        int i = left, j = mid, k = left;
        long inv = 0;
        while (i <= mid - 1 && j <= right) {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else {
                temp[k++] = arr[j++];
                inv += mid - i;
            }
        }

        while (i <= mid - 1)
            temp[k++] = arr[i++];
        while (j <= right)
            temp[k++] = arr[j++];
        for (i = left; i <= right; i++)
            arr[i] = temp[i];
        return inv;
    }
}