import java.util.*;
import java.io.*;
/*************************************************************
    Following is the Binary Tree node structure

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
    public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(floorInBST(root, key));
        result.add(ceilInBST(root, key));
        return result;
    }

    private static int ceilInBST(BinaryTreeNode<Integer> root, int x) {
        int ceil = -1;
        while (root != null) {
            if (root.data <= x) {
                root = root.right;
            } else {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }

    private static int floorInBST(BinaryTreeNode<Integer> root, int x) {
        int floor = -1;
        while (root != null) {
            if (root.data >= x) {
                root = root.left;
            } else {
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
    }
}