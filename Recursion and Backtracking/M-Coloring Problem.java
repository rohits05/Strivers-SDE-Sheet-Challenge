import java.util.*;
import java.io.*;

public class Solution {
    public static String graphColoring(int[][] mat, int m) {
        int n = mat.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[i].length; j++)
                if (mat[i][j] != 0)
                    adjList.get(i).add(j);

        int[] color = new int[n];
        if (checkGraphColoring(adjList, color, 0, m))
            return "YES";
        return "NO";
    }

    public static boolean isSafe(int node, int[] color, List<List<Integer>> adjList, int col) {
        for (int it : adjList.get(node))
            if (color[it] == col)
                return false;
        return true;
    }

    public static boolean checkGraphColoring(List<List<Integer>> adjList, int[] color, int node, int m) {
        if (node == adjList.size())
            return true;

        for (int col = 1; col <= m; col++) {
            if (isSafe(node, color, adjList, col)) {
                color[node] = col;
                if (checkGraphColoring(adjList, color, node + 1, m))
                    return true;
                color[node] = 0;
            }
        }

        return false;
    }
}
