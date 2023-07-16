import java.util.*;
import java.io.*;

/*******************************************************
 * 
 * Following is the BinaryTreeNode class structure:
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
 *******************************************************/

public class Solution {

    public static boolean identicalTrees(BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q) {
        // Write you code here.
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;

        return p.data.equals(q.data) && identicalTrees(p.left, q.left)
                && identicalTrees(p.right, q.right);
    }

}