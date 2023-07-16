
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
import java.util.*;
import java.io.*;

public class Solution {
    public static String serializeTree(TreeNode<Integer> root) {
        // Write your code here for serialization of the tree.
        if (root == null)
            return "";

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode<Integer> node = q.poll();

            if (node == null) {
                res.append("n ");
                continue;
            }
            res.append(node.data + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    public static TreeNode<Integer> deserializeTree(String data) {
        // Write your code here for deserialization of the tree.
        if (data == "")
            return null;

        Queue<TreeNode> q = new LinkedList<>();
        String values[] = data.split(" ");
        TreeNode<Integer> root = new TreeNode(Integer.parseInt(values[0]));

        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode<Integer> parent = q.poll();

            if (!values[i].equals("n")) {
                TreeNode<Integer> left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode<Integer> right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}
