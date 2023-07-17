import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Solution {
    static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        int[][] dist = new int[n + 1][n + 1];
        int high = 1000000000;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == j)
                    dist[i][j] = 0;
                else
                    dist[i][j] = high;
            }
        }

        for (int i = 0; i < m; i++) {
            int u = edges.get(i).get(0), v = edges.get(i).get(1);
            int w = edges.get(i).get(2);
            dist[u][v] = w;
        }

        for (int k = 1; k <= n; k++) {
            for (int u = 1; u <= n; u++)
                for (int v = 1; v <= n; v++)
                    if ((dist[u][k] != high && dist[k][v] != high) && dist[u][k] + dist[k][v] < dist[u][v])
                        dist[u][v] = dist[u][k] + dist[k][v];
        }

        boolean hasCycle = false;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++)
                if (i == j && dist[i][j] != 0)
                    hasCycle = true;
        }

        if (hasCycle)
            return -1;
        return dist[src][dest];
    }
}
