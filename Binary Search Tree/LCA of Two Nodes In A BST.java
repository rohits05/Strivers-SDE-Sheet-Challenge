import java.util.*;
import java.io.*;
/*

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

*/

public class Solution {
    public static TreeNode<Integer> lca(TreeNode<Integer> root, int val1, int val2) {
        if (root == null)
            return null;
        if (root.data == val1 || root.data == val2)
            return root;

        TreeNode<Integer> l = null;
        TreeNode<Integer> r = null;
        if (val1 < root.data && val2 < root.data)
            l = lca(root.left, val1, val2);
        else if (val1 > root.data && val2 > root.data)
            r = lca(root.right, val1, val2);
        else {
            l = lca(root.left, val1, val2);
            r = lca(root.right, val1, val2);
        }

        if (l != null && r != null)
            return root;
        else if (l == null && r != null)
            return r;
        else if (l != null && r == null)
            return l;
        else
            return null;
    }

    public static TreeNode<Integer> LCAinaBST(TreeNode<Integer> root, TreeNode<Integer> P, TreeNode<Integer> Q) {
        return lca(root, P.data, Q.data);
    }
}