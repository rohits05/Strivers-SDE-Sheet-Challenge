import java.util.*;
import java.io.*;
/*
	
	Following is the Binary Tree node structure:

	public class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.data = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	       this.data = val;
	        this.left = left;
	        this.right = right;
	    }
	}

*/

public class Solution {
    public static List<Integer> getPreOrderTraversal(TreeNode root) {
        // Write your code here.
        // recursive Approach !!
        // List<Integer> in = new LinkedList<Integer>();
        // if(root == null) return in; # 1

        // inHelper(root, in);
        // in.add(root.val); # 1
        // in.addAll(inorderTraversal(root.left)); # 1
        // in.addAll(inorderTraversal(root.right)); # 1
        // return in;

        // Iterative Approach !!
        List<Integer> trav = new ArrayList<Integer>();
        if (root == null)
            return trav;

        Stack<TreeNode> pickup = new Stack<TreeNode>();
        pickup.push(root);

        while (!pickup.isEmpty()) {
            root = pickup.pop();
            trav.add(root.data);
            if (root.right != null)
                pickup.push(root.right);
            if (root.left != null)
                pickup.push(root.left);
        }

        return trav;
    }

    public void inHelper(TreeNode root, List<Integer> in) {
        if (root == null)
            return;

        in.add(root.data);
        inHelper(root.left, in);
        inHelper(root.right, in);
    }
}