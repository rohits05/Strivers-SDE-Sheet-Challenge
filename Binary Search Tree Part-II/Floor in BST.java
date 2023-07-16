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

    public static int floorInBST(TreeNode<Integer> root, int X) {
        // Write your code here.
        if (root == null)
            return Integer.MAX_VALUE;
        if (root.data == X)
            return X;
        if (root.data > X)
            return floorInBST(root.left, X);
        else {
            int floorValue = floorInBST(root.right, X);
            if (floorValue <= X)
                return floorValue;
            else
                return root.data;
        }
    }
}