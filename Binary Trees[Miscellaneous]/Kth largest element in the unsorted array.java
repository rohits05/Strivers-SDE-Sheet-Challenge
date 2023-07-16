import java.util.*;
import java.io.*;

public class Solution {

    static int kthLargest(ArrayList<Integer> arr, int size, int K) {
        // Write your code here.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int x : arr) {
            minHeap.offer(x);
            if (minHeap.size() > K)
                minHeap.poll();
        }

        return minHeap.peek();
    }
}
