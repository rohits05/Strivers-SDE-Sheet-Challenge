import java.util.*;
import java.io.*;

/************************************************************
 * 
 * Following is the TreeNode class structure.
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
    public static TreeNode<Integer> flattenBinaryTree(TreeNode<Integer> root) {
        // Write your code here.
        if (root == null)
            return null;

        TreeNode<Integer> left = flattenBinaryTree(root.left);
        TreeNode<Integer> right = flattenBinaryTree(root.right);
        root.left = null;

        if (left != null) {
            root.right = left;
            while (left.right != null)
                left = left.right;
            left.right = right;
        } else
            root.right = right;
        return root;
    }
}