import java.util.*;
import java.io.*;
/************************************************************

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

************************************************************/

import java.util.ArrayList;

public class Solution {
    public static TreeNode<Integer> buildBinaryTree(ArrayList<Integer> inorder, ArrayList<Integer> preorder) {
        if (inorder == null || preorder == null || inorder.size() != preorder.size())
            return null;
        int n = inorder.size();
        return buildTreeHelper(inorder, 0, n - 1, preorder, 0, n - 1);
    }

    private static TreeNode<Integer> buildTreeHelper(ArrayList<Integer> inorder, int inStart, int inEnd,
            ArrayList<Integer> preorder, int preStart, int preEnd) {
        if (inStart > inEnd || preStart > preEnd)
            return null;

        int rootValue = preorder.get(preStart);
        TreeNode<Integer> root = new TreeNode<>(rootValue);
        int rootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder.get(i) == rootValue) {
                rootIndex = i;
                break;
            }
        }

        if (rootIndex == -1)
            return null;
        int leftSubtreeSize = rootIndex - inStart, rightSubtreeSize = inEnd - rootIndex;

        root.left = buildTreeHelper(inorder, inStart, rootIndex - 1, preorder, preStart + 1,
                preStart + leftSubtreeSize);
        root.right = buildTreeHelper(inorder, rootIndex + 1, inEnd, preorder, preEnd - rightSubtreeSize + 1, preEnd);
        return root;
    }
}