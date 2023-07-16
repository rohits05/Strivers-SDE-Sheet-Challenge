import java.util.*;
import java.io.*;

public class Solution {
    public static int heightOfTheTree(int[] inorder, int[] levelOrder, int n) {
        // Write your code here.
        int ans = 0;
        Queue<Node> q = new LinkedList<>();

        Node root = new Node(0, 0, n - 1);
        q.add(root);

        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++)
            mp.put(inorder[i], i);

        for (int i = 0; i < n; i++) {
            Node temp = q.poll();

            ans = Math.max(ans, temp.h);

            int li = temp.li, ri = temp.ri;
            int rootIndexOfSubTree = mp.get(levelOrder[i]);

            if (rootIndexOfSubTree - 1 >= li) {
                Node lst = new Node(temp.h + 1, li, rootIndexOfSubTree - 1);
                q.add(lst);
            }

            if (rootIndexOfSubTree + 1 <= ri) {
                Node rst = new Node(temp.h + 1, rootIndexOfSubTree + 1, ri);
                q.add(rst);
            }
        }

        return ans;
    }

    static class Node {
        int h, li, ri;

        public Node(int h, int li, int ri) {
            this.h = h;
            this.li = li;
            this.ri = ri;
        }
    }

}