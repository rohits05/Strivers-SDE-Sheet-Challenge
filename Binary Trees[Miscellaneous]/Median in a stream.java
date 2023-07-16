import java.util.*;
import java.io.*;

public class Solution {
    private static int[] convertToIntArray(ArrayList<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            arr[i] = list.get(i);
        return arr;
    }

    public static int[] findMedian(int[] arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int l = 0, r = 0;

        for (int i = 0; i < n; i++) {
            if (l == 0 || arr[i] <= maxHeap.peek()) {
                maxHeap.add(arr[i]);
                l++;
            } else {
                minHeap.add(arr[i]);
                r++;
            }

            if (l - r > 1) {
                int t = maxHeap.poll();
                l--;
                minHeap.add(t);
                r++;
            }

            if (l < r) {
                int t = minHeap.poll();
                r--;
                maxHeap.add(t);
                l++;
            }

            int median;
            if (l == r)
                median = (maxHeap.peek() + minHeap.peek()) / 2;
            else
                median = maxHeap.peek();

            ans.add(median);
        }

        return convertToIntArray(ans);
    }
}