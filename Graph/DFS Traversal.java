import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int V, int E, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).get(0), v = edges.get(i).get(1);
            adj[u].add(v);
            adj[v].add(u);
        }

        ArrayList<Integer> vis = new ArrayList<>(Collections.nCopies(V, 0));
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (vis.get(i) == 0) {
                ArrayList<Integer> ls = new ArrayList<>();
                dfs(i, adj, vis, ls);
                ans.add(ls);
            }
        }

        return ans;
    }

    private static void dfs(int node, ArrayList<Integer>[] adj, ArrayList<Integer> vis, ArrayList<Integer> ls) {
        vis.set(node, 1);
        ls.add(node);

        for (int it : adj[node])
            if (vis.get(it) == 0)
                dfs(it, adj, vis, ls);
    }
}