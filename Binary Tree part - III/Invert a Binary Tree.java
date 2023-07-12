import java.util.*;
import java.io.*;

/************************************************************
 * 
 * Following is the TreeNode class structure
 * 
 * class TreeNode<T>
 * {
 * public:
 * T data;
 * TreeNode<T> left;
 * TreeNode<T> right;
 * 
 * TreeNode(T data)
 * {
 * this.data = data;
 * left = null;
 * right = null;
 * }
 * };
 * 
 ************************************************************/

public class Solution {
    public static TreeNode<Integer> invertBinaryTree(TreeNode<Integer> root, TreeNode<Integer> leaf) {
        // Write your code here.
        if (root == null)
            return root;

        ArrayList<TreeNode<Integer>> st = new ArrayList<>();

        boolean flag = findNode(root, leaf, st);

        TreeNode<Integer> newHead = st.get(st.size() - 1);

        st.remove(st.size() - 1);

        TreeNode<Integer> parent = newHead;

        TreeNode<Integer> cur = null;

        while (st.size() > 0) {

            cur = st.get(st.size() - 1);

            st.remove(st.size() - 1);

            parent.left = cur;

            if (cur.left != parent) {

                cur.right = cur.left;

                cur.left = null;

            }

            else {

                cur.left = null;

            }

            parent = parent.left;

        }

        return newHead;

    }

    public static boolean findNode(TreeNode<Integer> root, TreeNode<Integer> leaf, ArrayList<TreeNode<Integer>> st) {
        st.add(root);
        if (root.left == null && root.right == null) {
            if (root.data.equals(leaf.data))
                return true;

            else {
                st.remove(st.size() - 1);
                return false;
            }
        }

        boolean left = false, right = false;

        if (root.left != null)
            left = findNode(root.left, leaf, st);
        if (left == true)
            return true;

        if (root.right != null)
            right = findNode(root.right, leaf, st);
        if (right == true)
            return true;

        st.remove(st.size() - 1);

        return false;
    }
}
