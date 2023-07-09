import java.util.*;
import java.io.*;

/************************************************************
 * 
 * Following is the TreeNode class structure
 * 
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * 
 * TreeNode(int val) {
 * this.val = val;
 * this.left = null;
 * this.right = null;
 * }
 * }
 * 
 * 
 ************************************************************/

public class Solution {
    public static int getMaxWidth(TreeNode root) {
        // Write your code here.
        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxWidth = 0;

        while (!q.isEmpty()) {
            int currWidth = q.size();
            if (maxWidth < currWidth)
                maxWidth = currWidth;
            while (currWidth > 0) {
                TreeNode currNode = q.peek();
                q.poll();
                if (currNode.left != null)
                    q.add(currNode.left);
                if (currNode.right != null)
                    q.add(currNode.right);
                currWidth = currWidth - 1;
            }
        }

        return maxWidth;
    }
}