import java.util.*;
import java.io.*;

/************************************************************
 * 
 * Following is the Tree node structure
 * 
 * class TreeNode {
 * int data;
 * TreeNode left;
 * TreeNode right;
 * 
 * TreeNode(int data) {
 * this.data = data;
 * this.left = null;
 * this.right = null;
 * }
 * 
 * }
 * 
 ************************************************************/

public class Solution {
    public static long findMaxSumPath(TreeNode root) {
        if (root == null)
            return -1;
        Result result = new Result();
        solve(root, result);
        return result.ans;
    }

    public static long solve(TreeNode root, Result result) {
        if (root == null)
            return Integer.MIN_VALUE;
        if (root.left == null && root.right == null)
            return root.data;

        long left = solve(root.left, result);
        long right = solve(root.right, result);
        if (left == Integer.MIN_VALUE || right == Integer.MIN_VALUE)
            return Math.max(left, right) + root.data;
        result.ans = Math.max(result.ans, left + right + root.data);
        return Math.max(left, right) + root.data;
    }

    static class Result {
        long ans;

        Result() {
            this.ans = -1;
        }
    }
}