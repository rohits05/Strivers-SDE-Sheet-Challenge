import java.util.*;
import java.io.*;
/*
	Following is the class used to represent the object/node of the Binary Tree

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}
*/

public class Solution {
    public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {
        // Write your code here!
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Deque<BinaryTreeNode<Integer>> deque = new LinkedList<>();
        boolean leftToRight = true;

        deque.offer(root);

        while (!deque.isEmpty()) {
            int levelSize = deque.size();

            for (int i = 0; i < levelSize; i++) {
                if (leftToRight) {
                    BinaryTreeNode<Integer> node = deque.pollFirst();
                    result.add(node.data);
                    if (node.left != null)
                        deque.offerLast(node.left);
                    if (node.right != null)
                        deque.offerLast(node.right);
                } else {
                    BinaryTreeNode<Integer> node = deque.pollLast();
                    result.add(node.data);
                    if (node.right != null)
                        deque.offerFirst(node.right);
                    if (node.left != null)
                        deque.offerFirst(node.left);
                }
            }

            leftToRight = !leftToRight;
        }

        return result;
    }
}
