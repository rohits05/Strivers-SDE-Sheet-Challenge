/*****************************************************************
 * 
 * Following is the representation for the Binary Tree Node:
 * 
 * class BinaryTreeNode<T> {
 * T data;
 * BinaryTreeNode<T> left;
 * BinaryTreeNode<T> right;
 * 
 * public BinaryTreeNode(T data) {
 * this.data = data;
 * }
 * }
 * 
 ****************************************************************/

public class Solution {

    public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
        if (root == null)
            return true;
        return checkSymmetric(root.left, root.right);
    }

    private static boolean checkSymmetric(BinaryTreeNode<Integer> left, BinaryTreeNode<Integer> right) {
        if (left == null && right == null)
            return true;
        else if (left == null || right == null)
            return false;

        else if (!left.data.equals(right.data))
            return false;

        else
            return checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left);
    }
}