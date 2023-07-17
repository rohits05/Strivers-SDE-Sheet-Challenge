import java.util.*;
import java.io.*;

public class Solution {
    public static ArrayList<Integer> BFS(int vertex, int edges[][]) {
        // WRITE YOUR CODE HERE
        List<List<Integer>> adjacency = new ArrayList<List<Integer>>();
        for (int i = 0; i < vertex; i++)
            adjacency.add(new ArrayList<Integer>());

        for (int i = 0; i < edges[0].length; i++) {
            adjacency.get(edges[0][i]).add(edges[1][i]);
            adjacency.get(edges[1][i]).add(edges[0][i]);
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        boolean[] visited = new boolean[vertex];

        for (int u = 0; u < vertex; u++) {
            if (visited[u])
                continue;
            visited[u] = true;
            queue.offer(u);
            result.add(u);
            while (!queue.isEmpty()) {
                int u2 = queue.poll();
                ArrayList<Integer> subResult = new ArrayList<Integer>();
                for (int v : adjacency.get(u2)) {
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.offer(v);
                        subResult.add(v);
                    }
                }
                Collections.sort(subResult);
                result.addAll(subResult);
            }
        }

        return result;
    }
}
