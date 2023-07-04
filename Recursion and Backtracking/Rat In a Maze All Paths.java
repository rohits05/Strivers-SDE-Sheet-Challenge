import java.util.*;
import java.io.*;

public class Solution {
    static int[][] path;
    static ArrayList<ArrayList<Integer>> route = new ArrayList<>();

    public static void p2A(int[][] mat) {
        int n = mat.length;
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mat.length; j++)
                temp.add(mat[i][j]);
        }
        route.add(temp);
        return;
    }

    public static void helper(int[][] maze, int n, int i, int j) {
        if (i == n - 1 && j == n - 1) {
            path[i][j] = 1;
            p2A(path);
            path[i][j] = 0;
            return;
        }

        if (i >= 0 && i < n && j >= 0 && j < n) {
            if (path[i][j] == 0 && maze[i][j] == 1) {
                path[i][j] = 1;
                helper(maze, n, i + 1, j);
                helper(maze, n, i, j + 1);
                helper(maze, n, i - 1, j);
                helper(maze, n, i, j - 1);
                path[i][j] = 0;
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
        route.clear();
        path = new int[n][n];
        helper(maze, n, 0, 0);
        return route;
    }
}