import java.util.*;
import java.io.*;
/*   
    Following is the Binary Tree node structure for referance:

    class TreeNode
    {
        int data;
        TreeNode left, right;
    
        public TreeNode(int item)
        {
            data = item;
            left = right = null;
        }
    }
*/

public class Solution {
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        // Write your code here..
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return new ArrayList<>();
        solve(root, x, ans);
        return ans;
    }

    static void solve(TreeNode root, int x, ArrayList<Integer> ans) {
        if (root == null)
            return;

        ans.add(root.data);
        if (root.data == x)
            return;
        solve(root.left, x, ans);
        solve(root.right, x, ans);
        if (ans.get(ans.size() - 1) != x)
            ans.remove(ans.size() - 1);
    }
}