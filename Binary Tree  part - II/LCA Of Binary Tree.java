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
    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) {
        // Write your code here.
        if (root == null)
            return -1;
        if (root.data == x || root.data == y)
            return root.data;

        int leftLca = lowestCommonAncestor(root.left, x, y);
        int rightLca = lowestCommonAncestor(root.right, x, y);

        if (rightLca == -1)
            return leftLca;
        if (leftLca == -1)
            return rightLca;

        return root.data;
    }
}
