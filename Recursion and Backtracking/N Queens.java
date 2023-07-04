import java.util.*;
import java.io.*;

public class Solution {
    static HashMap<Integer, Integer> diag = new HashMap<>();
    static HashMap<Integer, Integer> opp = new HashMap<>();
    static HashMap<Integer, Integer> col = new HashMap<>();
    static HashMap<Integer, Integer> row = new HashMap<>();
    static int[][] queen;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    public static void helper(int n) {
        int len = queen.length;
        if (n == len) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++)
                    temp.add(queen[i][j]);
            }

            arr.add(temp);
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!diag.containsKey(i - n) && !opp.containsKey(i + n)
                    && !col.containsKey(i) && !row.containsKey(n)) {
                diag.put(i - n, 1);
                opp.put(i + n, 1);
                col.put(i, 1);
                row.put(n, 1);
                queen[n][i] = 1;
                helper(n + 1);
                queen[n][i] = 0;
                diag.remove(i - n);
                opp.remove(i + n);
                col.remove(i);
                row.remove(n);
            }
        }

    }

    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        queen = new int[n][n];
        arr.clear();
        diag.clear();
        opp.clear();
        col.clear();
        row.clear();
        helper(0);
        return arr;
    }
}