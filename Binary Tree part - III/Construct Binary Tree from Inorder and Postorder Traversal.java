/************************************************************
 * 
 * Following is the TreeNode class structure
 * 
 * class TreeNode<T> {
 * T data;
 * TreeNode<T> left;
 * TreeNode<T> right;
 * 
 * TreeNode(T data) {
 * this.data = data;
 * left = null;
 * right = null;
 * }
 * }
 * 
 ************************************************************/

public class Solution {
    public static TreeNode<Integer> getTreeFromPostorderAndInorder(int[] postOrder, int[] inOrder) {
        if (postOrder == null || inOrder == null || postOrder.length != inOrder.length)
            return null;
        int n = postOrder.length;
        return buildTreeHelper(postOrder, 0, n - 1, inOrder, 0, n - 1);
    }

    private static TreeNode<Integer> buildTreeHelper(int[] postOrder, int postStart, int postEnd, int[] inOrder,
            int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd)
            return null;

        int rootValue = postOrder[postEnd];
        TreeNode<Integer> root = new TreeNode<>(rootValue);
        int rootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        if (rootIndex == -1)
            return null;

        int leftSubtreeSize = rootIndex - inStart, rightSubtreeSize = inEnd - rootIndex;

        root.left = buildTreeHelper(postOrder, postStart, postStart + leftSubtreeSize - 1, inOrder, inStart,
                rootIndex - 1);
        root.right = buildTreeHelper(postOrder, postStart + leftSubtreeSize, postEnd - 1, inOrder, rootIndex + 1,
                inEnd);

        return root;
    }
}
