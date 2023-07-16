import java.util.*;
import java.io.*;

/*************************************************************
 * 
 * Following is the Binary Tree node structure
 * 
 * class BinaryTreeNode<Integer> {
 * int data;
 * BinaryTreeNode<Integer> left;
 * BinaryTreeNode<Integer> right;
 * 
 * public BinaryTreeNode(int data) {
 * this.data = data;
 * }
 * }
 * 
 *************************************************************/

public class Solution {
    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        // Write your code here
        if (root == null)
            return true;

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> t = queue.poll();

            if (t.left != null && t.left.data > t.data)
                return false;

            if (t.right != null && t.right.data < t.data)
                return false;

            if (t.left != null)
                queue.add(t.left);

            if (t.right != null)
                queue.add(t.right);
        }

        return true;
    }
}
