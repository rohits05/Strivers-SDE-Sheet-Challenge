import java.util.*;
import java.io.*;

public class Solution {
    static class Pair {
        int prv, n;

        Pair(int n, int prv) {
            this.prv = prv;
            this.n = n;
        }
    }

    public static String cycleDetection(int[][] edges, int n, int m) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean vis[] = new boolean[n + 1];
        for (int i = 0; i < n + 1; ++i) {
            vis[i] = false;
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; ++i) {
            adj.get(edges[i][0]).add(Integer.valueOf(edges[i][1]));
            adj.get(edges[i][1]).add(Integer.valueOf(edges[i][0]));
        }

        Queue<Pair> q = new LinkedList<Pair>();
        for (int i = 1; i <= n; ++i) {
            if (!vis[i]) {
                q.add(new Pair(i, -1));
                while (!q.isEmpty()) {
                    Pair t = q.remove();
                    if (!vis[t.n]) {
                        vis[t.n] = true;
                        for (Integer j : adj.get(t.n))
                            if (!vis[j])
                                q.add(new Pair(j, t.n));
                    } else
                        return "Yes";
                }
            }
        }

        return "No";
    }
}