import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Solution {
    public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
        // Write your code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            minHeap.add(arr.get(i));
            maxHeap.add(arr.get(i));
        }

        for (int i = k; i < arr.size(); i++) {
            if (minHeap.peek() < arr.get(i)) {
                minHeap.poll();
                minHeap.add(arr.get(i));
            }
            if (maxHeap.peek() > arr.get(i)) {
                maxHeap.poll();
                maxHeap.add(arr.get(i));
            }
        }
        ans.add(maxHeap.poll());
        ans.add(minHeap.poll());

        return ans;
    }
}
