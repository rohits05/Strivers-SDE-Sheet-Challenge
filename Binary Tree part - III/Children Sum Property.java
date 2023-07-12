import java.util.*;
import java.io.*;

/*************************************************************
 * 
 * Following is the Binary Tree node structure
 * 
 * class BinaryTreeNode < Integer > {
 * int data;
 * BinaryTreeNode < Integer > left;
 * BinaryTreeNode < Integer > right;
 * 
 * public BinaryTreeNode(int data) {
 * this.data = data;
 * }
 * }
 * 
 *************************************************************/

public class Solution {
    public static void changeTree(BinaryTreeNode<Integer> root) {
        // Write your code here.
        traverse(root, Integer.MAX_VALUE);
    }

    public static int traverse(BinaryTreeNode<Integer> root, int parentVal) {
        if (root == null)
            return Integer.MAX_VALUE;

        int temp = parentVal != Integer.MAX_VALUE && parentVal > root.data ? parentVal : root.data;
        int left = traverse(root.left, temp);
        int right = traverse(root.right, temp);

        if (left == Integer.MAX_VALUE && right == Integer.MAX_VALUE) {
            if (parentVal >= root.data)
                root.data = parentVal;
        } else if (left == Integer.MAX_VALUE)
            root.data = right;
        else if (right == Integer.MAX_VALUE)
            root.data = left;
        else
            root.data = left + right;

        return root.data;
    }
}