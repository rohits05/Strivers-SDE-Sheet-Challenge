import java.util.*;
import java.io.*;
/*
    Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    public T data;
	    public BinaryTreeNode<T> left;
	    public BinaryTreeNode<T> right;

	    BinaryTreeNode(T data) {
	        this.data = data;
	        this.left = null;
	        this.right = null;
	    }
	}
*/

public class Solution {
    public static Boolean searchInBST(BinaryTreeNode<Integer> root, int x) {
        // Write your code here.
        if (root == null)
            return false;
        if (root.data == x)
            return true;
        if (root.data > x)
            return searchInBST(root.left, x);
        else
            return searchInBST(root.right, x);
    }
}