import java.util.*;
import java.io.*;

public class Solution {
    public static int kruskalMST(int n, int m, ArrayList<ArrayList<Integer>> graph) {
        DisjointSet set = new DisjointSet(n);
        Edge[] edges = new Edge[m];

        for (int i = 0; i < m; i++) {
            List<Integer> edge = graph.get(i);
            edges[i] = new Edge(edge.get(0), edge.get(1), edge.get(2));
        }

        Arrays.sort(edges);
        int totalWeight = 0;
        for (int i = 1, j = 0; i < n; j++) {
            Edge edge = edges[j];
            int u = find(set, edge.u), v = find(set, edge.v);
            if (u != v) {
                union(set, u, v);
                totalWeight += edge.w;
                i++;
            }
        }

        return totalWeight;
    }

    private static int find(DisjointSet set, int u) {
        if (u != set.parent[u])
            set.parent[u] = find(set, set.parent[u]);
        return set.parent[u];
    }

    private static void union(DisjointSet set, int u, int v) {
        int pU = set.parent[u], pV = set.parent[v];

        if (set.rank[pU] < set.rank[pV])
            set.parent[pU] = pV;
        else if (set.rank[pU] > set.rank[pV])
            set.parent[pV] = pU;
        else {
            set.parent[pV] = pU;
            set.rank[pU]++;
        }
    }

    private static class Edge implements Comparable<Edge> {
        final int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(w, other.w);
        }
    }

    private static class DisjointSet {
        final int[] parent, rank;

        DisjointSet(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++)
                parent[i] = i;
        }
    }
}