import java.util.*;
import java.io.*;

public class Solution {

    public static List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
        // Write your code here
        List<Integer>[] adj1 = new List[n];
        List<Integer>[] adj2 = new List[n];
        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj1[i] = new ArrayList<>();
            adj2[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj1[u].add(v);
            adj2[v].add(u);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i])
                topologicalSort(adj1, i, visited, st);
        }

        visited = new boolean[n];

        while (!st.empty()) {
            int u = st.pop();
            List<Integer> ans = new ArrayList<>();
            if (!visited[u]) {
                DFS(adj2, u, visited, ans);
                res.add(ans);
            }
        }

        return res;
    }

    private static void topologicalSort(List<Integer>[] adj, int S, boolean[] visited, Stack<Integer> st) {
        visited[S] = true;
        for (int v : adj[S]) {
            if (!visited[v])
                topologicalSort(adj, v, visited, st);
        }
        st.push(S);
    }

    private static void DFS(List<Integer>[] adj, int s, boolean[] visited, List<Integer> ans) {
        visited[s] = true;
        ans.add(s);
        for (int v : adj[s]) {
            if (!visited[v])
                DFS(adj, v, visited, ans);
        }
    }
}