import java.util.*;
import java.io.*;

public class Solution {
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int vtx, int edg) {
        // Write your code here
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < vtx; i++)
            adjacencyList.add(new ArrayList<>());

        int[] indegree = new int[vtx];
        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            adjacencyList.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vtx; i++)
            if (indegree[i] == 0)
                queue.add(i);

        ArrayList<Integer> output = new ArrayList<Integer>();
        int count = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            output.add(u);

            for (int t = 0; t < adjacencyList.get(u).size(); t++) {
                int v = adjacencyList.get(u).get(t);
                indegree[v]--;
                if (indegree[v] == 0)
                    queue.add(v);
            }
        }

        return output;
    }
}
