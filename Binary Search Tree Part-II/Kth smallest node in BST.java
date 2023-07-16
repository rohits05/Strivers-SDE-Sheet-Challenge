import java.util.*;
import java.io.*;

/************************************************************
 * 
 * Following is the TreeNode class structure
 * 
 * class TreeNode<T>
 * {
 * public T data;
 * public TreeNode<T> left;
 * public TreeNode<T> right;
 * 
 * TreeNode(T data)
 * {
 * this.data = data;
 * left = null;
 * right = null;
 * }
 * }
 * 
 ************************************************************/

public class Solution {

    public static int kthSmallest(TreeNode<Integer> root, int k) {
        int[] count = { k };
        return solve(root, count);
    }

    private static int solve(TreeNode<Integer> root, int[] k) {
        if (root == null)
            return -1;

        int left = solve(root.left, k);
        if (left != -1)
            return left;

        k[0]--;
        if (k[0] == 0)
            return root.data;

        int right = solve(root.right, k);
        return right;
    }

}
