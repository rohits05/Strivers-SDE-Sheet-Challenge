import java.util.*;
import java.io.*;

public class Solution {
    public static int getTotalIslands(int[][] mat) {
        // Your code goes here
        int n = mat.length, m = mat[0].length;
        int cnt = 0;
        int[][] vis = new int[n][m];
        int[][] dir = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && mat[i][j] == 1) {
                    dfs(mat, vis, dir, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void dfs(int[][] mat, int[][] vis, int[][] dir, int row, int col) {
        vis[row][col] = 1;

        for (int[] child : dir) {
            int newRow = row + child[0], newCol = col + child[1];

            if (newRow >= 0 && newRow < mat.length && newCol >= 0 && newCol < mat[0].length
                    && vis[newRow][newCol] == 0 && mat[newRow][newCol] == 1) {
                dfs(mat, vis, dir, newRow, newCol);
            }
        }
    }
}