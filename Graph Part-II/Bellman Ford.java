import java.util.*;
import java.io.*;

public class Solution {
    static int bellmonFord(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        int[] distances = new int[n + 1];
        Arrays.fill(distances, (int) 1e9);
        distances[src] = 0;

        for (int i = 1; i < n; i++) {
            for (ArrayList<Integer> edge : edges) {
                int u = edge.get(0), v = edge.get(1);
                int weight = edge.get(2);

                if (distances[v] > distances[u] + weight && distances[u] != (int) 1e9)
                    distances[v] = distances[u] + weight;
            }
        }

        return distances[dest];
    }
}
