import java.util.*;
import java.io.*;

public class Kthlargest {
    PriorityQueue<Integer> pq;
    int k;

    Kthlargest(int k, int[] arr) {
        // Write your code here.
        pq = new PriorityQueue<>();
        this.k = k;
        for (int num : arr)
            add(num);
    }

    void add(int num) {
        // Write your code here.
        pq.offer(num);
        if (pq.size() > k)
            pq.poll();
    }

    int getKthLargest() {
        // Write your code here.
        return pq.peek();
    }
}
