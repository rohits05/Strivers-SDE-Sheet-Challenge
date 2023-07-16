import java.util.*;
import java.io.*;
/*
    ----------------- Binary Tree node class for reference -----------------

    class BinaryTreeNode<T> {
	    public T data;
	    public BinaryTreeNode<T> left;
	    public BinaryTreeNode<T> right;
	    public BinaryTreeNode<T> next;

	    BinaryTreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	        next = null;
	    }
	};

*/

public class Solution {
    public static void connectNodes(BinaryTreeNode<Integer> root) {
        // Write your code here.
        BinaryTreeNode<Integer> dummy = new BinaryTreeNode<Integer>(null);

        while (root != null) {
            BinaryTreeNode<Integer> curr = root;
            BinaryTreeNode<Integer> next = dummy;

            while (curr != null) {
                if (curr.left != null)
                    next = next.next = curr.left;
                if (curr.right != null)
                    next = next.next = curr.right;
                curr = curr.next;
            }
            root = dummy.next;
            dummy.next = null;
        }
    }
}