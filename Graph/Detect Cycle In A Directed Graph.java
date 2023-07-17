import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Solution {
    public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<Integer>());
        for (int i = 0; i < edges.size(); i++)
            graph.get(edges.get(i).get(0)).add(edges.get(i).get(1));

        int[] ind = new int[n + 1];
        Arrays.fill(ind, 0);

        for (int i = 1; i <= n; i++)
            for (int j : graph.get(i))
                ind[j]++;

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++)
            if (ind[i] == 0)
                queue.add(i);

        while (!queue.isEmpty()) {
            int front = queue.poll();
            count++;

            for (int i : graph.get(front)) {
                ind[i]--;

                if (ind[i] == 0)
                    queue.add(i);
            }
        }

        if (count != n)
            return true;
        else
            return false;
    }
}