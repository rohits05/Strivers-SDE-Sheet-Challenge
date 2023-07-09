import java.util.*;
import java.io.*;

/************************************************************
 * 
 * Following is the Binary Tree node structure:
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
 ************************************************************/

public class Solution {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        inorder(inOrder, root);
        res.add(inOrder);
        preorder(preOrder, root);
        res.add(preOrder);
        postorder(postOrder, root);
        res.add(postOrder);
        return res;
    }

    public static void preorder(List<Integer> preOrder, BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        preOrder.add(root.data);
        preorder(preOrder, root.left);
        preorder(preOrder, root.right);
    }

    public static void inorder(List<Integer> inOrder, BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        inorder(inOrder, root.left);
        inOrder.add(root.data);
        inorder(inOrder, root.right);
    }

    public static void postorder(List<Integer> postOrder, BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        postorder(postOrder, root.left);
        postorder(postOrder, root.right);
        postOrder.add(root.data);
    }
}
