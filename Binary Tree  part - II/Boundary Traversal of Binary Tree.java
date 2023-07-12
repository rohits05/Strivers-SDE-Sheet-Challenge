import java.util.*;
import java.io.*;
/************************************************************

    Following is the Binary Tree node structure:
    
   class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int data) {
		    this.data = data;
		    this.left = null;
		    this.right = null;
	    }

    }

************************************************************/

import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> traverseBoundary(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        result.add(root.data);

        result = traverseLeftBoundary(root.left, result);
        result = traverseLeafNodes(root.left, result);
        result = traverseLeafNodes(root.right, result);
        result = traverseRightBoundary(root.right, result);

        return result;
    }

    public static ArrayList<Integer> traverseLeftBoundary(TreeNode root, ArrayList<Integer> result) {
        if (root == null || (root.left == null && root.right == null))
            return result;

        result.add(root.data);

        if (root.left != null)
            result = traverseLeftBoundary(root.left, result);
        else if (root.right != null)
            result = traverseLeftBoundary(root.right, result);

        return result;
    }

    public static ArrayList<Integer> traverseRightBoundary(TreeNode root, ArrayList<Integer> result) {
        if (root == null || (root.left == null && root.right == null))
            return result;

        if (root.right != null)
            result = traverseRightBoundary(root.right, result);
        else if (root.left != null)
            result = traverseRightBoundary(root.left, result);

        result.add(root.data);

        return result;
    }

    public static ArrayList<Integer> traverseLeafNodes(TreeNode root, ArrayList<Integer> result) {
        if (root == null)
            return result;

        if (root.left == null && root.right == null)
            result.add(root.data);

        result = traverseLeafNodes(root.left, result);
        result = traverseLeafNodes(root.right, result);

        return result;
    }
}