import java.util.*;
import java.io.*;

/*
    Definition of Node class for reference

    class TreeNode<T> 
    {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

*/
public class Solution {

    static class BSTIterator {
        List<Integer> list = new ArrayList<>();
        int idx = 0;

        void inOrder(TreeNode<Integer> root) {
            if (root == null)
                return;

            inOrder(root.left);
            list.add(root.data);
            inOrder(root.right);
        }

        BSTIterator(TreeNode<Integer> root) {
            // Write your code here
            inOrder(root);
        }

        int next() {
            // Write your code here
            return list.get(idx++);
        }

        boolean hasNext() {
            // Write your code here
            return idx < list.size();
        }
    }
}

/*
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator iterator = new BSTIterator(root);
 * while(iterator.hasNext())
 * {
 * print(iterator.next()+" ");
 * }
 */
