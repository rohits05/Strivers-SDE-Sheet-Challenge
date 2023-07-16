import java.util.*;
import java.io.*;

/*************************************************************
 * Following is the Binary Tree node structure
 * class TreeNode<T> {
 * public T data;
 * public TreeNode<T> left;
 * public TreeNode<T> right;
 * 
 * TreeNode(T data) {
 * this.data = data;
 * left = right = null;
 * }
 * 
 * };
 ************************************************************/
public class Solution {

    public static TreeNode<Integer> preOrderTree(int[] preOrder) {
        // Write your code here
        int[] inorder = preOrder.clone();
        Arrays.sort(inorder);
        Map<Integer, Integer> inmap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++)
            inmap.put(inorder[i], i);

        TreeNode root = buildtree(preOrder, 0, preOrder.length - 1, inorder, 0, inorder.length - 1, inmap);
        return root;
    }

    public static TreeNode<Integer> buildtree(int[] preOrder, int prestart, int preend, int[] inorder, int instart,
            int inend, Map<Integer, Integer> inmap) {
        if (prestart > preend || instart > inend)
            return null;

        TreeNode root = new TreeNode(preOrder[prestart]);
        int inroot = inmap.get(root.data), numleft = inroot - instart;

        root.left = buildtree(preOrder, prestart + 1, prestart + numleft, inorder,
                instart, inroot - 1, inmap);

        root.right = buildtree(preOrder, prestart + 1 + numleft, preend, inorder,
                inroot + 1, inend, inmap);

        return root;
    }

}
