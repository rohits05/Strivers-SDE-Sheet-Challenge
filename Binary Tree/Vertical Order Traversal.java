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
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) {
        // Write your code here.
        TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.add(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple tem = q.poll();
            TreeNode node = tem.node;
            int x = tem.r;
            int y = tem.c;
            if (!map.containsKey(x))
                map.put(x, new TreeMap<>());
            if (!map.get(x).containsKey(y))
                map.get(x).put(y, new ArrayList<Integer>());
            map.get(x).get(y).add(tem.node.data);
            if (node.left != null)
                q.add(new Tuple(node.left, x - 1, y + 1));
            if (node.right != null)
                q.add(new Tuple(node.right, x + 1, y + 1));
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (TreeMap<Integer, ArrayList<Integer>> par : map.values()) {
            for (ArrayList<Integer> pq : par.values())
                for (int k : pq)
                    ans.add(k);

        }

        return ans;
    }

    static class Tuple {
        TreeNode<Integer> node;
        int r, c;

        public Tuple(TreeNode<Integer> _node, int _row, int _col) {
            node = _node;
            r = _row;
            c = _col;
        }
    }
}
