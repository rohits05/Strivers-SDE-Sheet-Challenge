import java.util.*;
import java.io.*;

/*************************************************************
 * 
 * Following is the Binary Tree node structure
 * 
 * class BinaryTreeNode<T>
 * {
 * T data;
 * BinaryTreeNode<T> left;
 * BinaryTreeNode<T> right;
 * 
 * BinaryTreeNode(T data) {
 * this.data = data;
 * left = null;
 * right = null;
 * }
 * };
 * 
 *************************************************************/
public class Solution {

    public static boolean isBalancedBT(BinaryTreeNode<Integer> root) {
        // Write your code here.
        return dfsHeight(root) != -1;
    }

    private static int dfsHeight(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;

        int lH = dfsHeight(root.left), rH = dfsHeight(root.right);

        if (lH == -1 || rH == -1)
            return -1;
        if (Math.abs(lH - rH) > 1)
            return -1;

        return Math.max(lH, rH) + 1;
    }
}
