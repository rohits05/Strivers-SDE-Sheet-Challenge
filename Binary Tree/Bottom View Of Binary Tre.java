import java.util.*;
import java.io.*;

/*********************************************
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
 *********************************************/

public class Solution {
    static class Pair {
        int hd;
        BinaryTreeNode node;

        public Pair(int hd, BinaryTreeNode node) {
            this.hd = hd;
            this.node = node;
        }
    }

    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
        // Write your code here.
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();

        q.add(new Pair(0, root));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            map.put(cur.hd, cur.node.val);

            if (cur.node.left != null)
                q.add(new Pair(cur.hd - 1, cur.node.left));
            if (cur.node.right != null)
                q.add(new Pair(cur.hd + 1, cur.node.right));
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            ans.add(entry.getValue());
        return ans;
    }
}
