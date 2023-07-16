import java.util.*;
import java.io.*;

/*************************************************************
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
 *************************************************************/

public class Solution {
    static BinaryTreeNode<Integer> head;

    public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
        head = null;
        morrisTraversal(root);
        return head;
    }

    static void morrisTraversal(BinaryTreeNode<Integer> root) {
        BinaryTreeNode<Integer> cur = root;
        BinaryTreeNode<Integer> prev = null;

        while (cur != null) {
            if (cur.left == null) {
                if (head == null)
                    head = cur;
                cur.left = prev;
                if (prev != null)
                    prev.right = cur;
                prev = cur;
                cur = cur.right;
            } else {
                BinaryTreeNode<Integer> next = cur.left;
                while (next.right != null && next.right != cur)
                    next = next.right;
                if (next.right == null) {
                    next.right = cur;
                    cur = cur.left;
                } else if (next.right == cur) {
                    cur.left = next;
                    prev = cur;
                    cur = cur.right;
                }
            }
        }
    }
}
