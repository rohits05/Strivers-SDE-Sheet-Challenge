import java.util.*;
import java.io.*;

/*************************************************************
 * 
 * Following is the Binary Tree node structure:
 * 
 * class BinaryTreeNode {
 * 
 * int data;
 * BinaryTreeNode left;
 * BinaryTreeNode right;
 * 
 * BinaryTreeNode(int data) {
 * this.data = data;
 * left = null;
 * right = null;
 * }
 * }
 * 
 *************************************************************/

public class Solution {
    public static boolean pairSumBst(BinaryTreeNode root, int k) {
        // Write your code here.
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);

        for (int i = 0, j = nums.size() - 1; i < j;) {
            if (nums.get(i) + nums.get(j) == k)
                return true;
            if (nums.get(i) + nums.get(j) < k)
                i++;
            else
                j--;
        }
        return false;
    }

    private static void inorder(BinaryTreeNode root, List<Integer> nums) {
        if (root == null)
            return;

        inorder(root.left, nums);
        nums.add(root.data);
        inorder(root.right, nums);
    }
}
