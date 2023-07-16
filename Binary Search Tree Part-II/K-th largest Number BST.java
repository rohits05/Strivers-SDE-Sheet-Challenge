import java.util.*;
import java.io.*;
/*************************************************************
    Following is the Binary Search Tree node structure

	class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

*************************************************************/

import java.util.ArrayList;

public class Solution {
    private static int cnt;
    private static int res;

    public static int KthLargestNumber(TreeNode<Integer> root, int k) {
        cnt = 0;
        res = -1;
        func(root, k);
        return res;
    }

    private static void func(TreeNode<Integer> root, int k) {
        if (root == null)
            return;
        func(root.right, k);
        cnt++;
        if (cnt == k) {
            res = root.data;
            return;
        }

        func(root.left, k);
    }
}