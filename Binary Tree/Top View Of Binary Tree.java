import java.util.*;
import java.io.*;

/************************************************************
 * 
 * Following is the TreeNode class structure:
 * 
 * class BinaryTreeNode {
 * int val;
 * BinaryTreeNode left;
 * BinaryTreeNode right;
 * 
 * BinaryTreeNode(int val) {
 * this.val = val;
 * this.left = null;
 * this.right = null;
 * }
 * }
 * 
 ************************************************************/

public class Solution {
    static class QueueObj {
        BinaryTreeNode node;
        int hd;

        QueueObj(BinaryTreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
        // Write your code here.
        ArrayList<Integer> arr = new ArrayList<>();
        if (root == null)
            return arr;

        Queue<QueueObj> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int min = 0, max = 0;
        queue.add(new QueueObj(root, 0));

        while (!queue.isEmpty()) {
            QueueObj curr = queue.poll();
            if (!map.containsKey(curr.hd))
                map.put(curr.hd, curr.node.val);

            if (curr.node.left != null) {
                min = Math.min(min, curr.hd - 1);
                queue.add(new QueueObj(curr.node.left, curr.hd - 1));
            }

            if (curr.node.right != null) {
                max = Math.max(max, curr.hd + 1);
                queue.add(new QueueObj(curr.node.right, curr.hd + 1));
            }

        }

        for (; min <= max; min++)
            arr.add(map.get(min));
        return arr;
    }
}