import java.util.*;
import java.io.*;
/****************************************************************

    Following is the class structure of the TreeNode class:

    class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }


*****************************************************************/

import java.util.ArrayList;

public class Solution {
    public static TreeNode<Integer> sortedArrToBST(ArrayList<Integer> arr, int n) {
        return helper(arr, 0, n - 1);
    }

    public static TreeNode<Integer> helper(ArrayList<Integer> arr, int s, int e) {
        if (s > e)
            return null;
        if (s == e)
            return new TreeNode<Integer>(arr.get(s));
        int mid = (s + e) / 2;
        TreeNode<Integer> temp = new TreeNode<Integer>(arr.get(mid));
        temp.left = helper(arr, s, mid - 1);
        temp.right = helper(arr, mid + 1, e);
        return temp;
    }
}