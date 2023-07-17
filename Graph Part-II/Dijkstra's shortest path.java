import java.util.*;
import java.io.*;

public class Solution {

    public static ArrayList<Integer> dijkstra(ArrayList<ArrayList<Integer>> vec, int vertices, int edges, int source) {
        // Write your code here.
        List<Pair>[] adj = new List[vertices];
        for (int i = 0; i < vertices; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < edges; i++) {
            int u = vec.get(i).get(0);
            int v = vec.get(i).get(1);
            int w = vec.get(i).get(2);
            adj[u].add(new Pair(v, w));
            adj[v].add(new Pair(u, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dis = new int[vertices];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[source] = 0;
        pq.offer(new Pair(source, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int u = p.vertex;
            int d = p.weight;

            if (d > dis[u])
                continue;

            for (Pair it : adj[u]) {
                int v = it.vertex;
                int t = it.weight;
                if (d + t < dis[v]) {
                    dis[v] = d + t;
                    pq.offer(new Pair(v, dis[v]));
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < vertices; i++)
            result.add(dis[i]);
        return result;
    }

    static class Pair implements Comparable<Pair> {
        int vertex;
        int weight;

        Pair(int v, int w) {
            vertex = v;
            weight = w;
        }

        public int compareTo(Pair other) {
            return weight - other.weight;
        }
    }
}