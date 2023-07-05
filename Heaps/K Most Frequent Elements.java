import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int key, val;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public int compareTo(Node other) {
        return this.val - other.val;
    }
}

public class Solution {
    public static int[] KMostFrequent(int n, int k, int[] arr) {
        // Write your code here.
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
            if (pq.size() > k)
                pq.poll();
        }

        int i = 0;

        while (!pq.isEmpty())
            res[i++] = pq.poll().key;
        return res;
    }
}
