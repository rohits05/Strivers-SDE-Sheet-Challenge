import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Solution {

    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {
        // Write your code here
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        convertToAdjacencyList(adj, edges);

        int n = edges.get(0).size();
        int[] color = new int[n];
        for (int i = 0; i < n; i++)
            color[i] = -1;

        for (int i = 0; i < n; i++) {
            if (color[i] == -1)
                if (!bfs(i, adj, color))
                    return false;
        }

        return true;
    }

    public static boolean bfs(int node, HashMap<Integer, List<Integer>> adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 1;

        while (!q.isEmpty()) {
            int parent = q.poll();

            for (int x : adj.get(parent)) {
                if (color[x] == -1) {
                    q.add(x);
                    color[x] = 1 - color[parent];
                } else if (color[x] == color[parent])
                    return false;
            }
        }

        return true;
    }

    public static void convertToAdjacencyList(HashMap<Integer, List<Integer>> adj,
            ArrayList<ArrayList<Integer>> edges) {
        for (int i = 0; i < edges.size(); i++) {
            adj.put(i, new ArrayList<>());
            for (int j = 0; j < edges.get(i).size(); j++)
                if (edges.get(i).get(j) == 1)
                    adj.get(i).add(j);
        }
    }
}