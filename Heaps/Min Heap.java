import java.util.*;
import java.io.*;

public class Solution {

    // minHeap function which take size of Queries and Queries as Input.
    // Returns an array out outputs depending on the query.
    static int[] minHeap(int n, int[][] q) {
        // Write your code here.
        int cnt = 0;
        for (int i = 0; i < n; i++)
            if (q[i][0] == 1)
                cnt += 1;

        int res[] = new int[cnt];
        int i = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int a[] : q) {
            if (a[0] == 0)
                pq.offer(a[1]);
            if (a[0] == 1) {
                res[i] = pq.poll();
                i += 1;
            }
        }

        return res;
    }
}