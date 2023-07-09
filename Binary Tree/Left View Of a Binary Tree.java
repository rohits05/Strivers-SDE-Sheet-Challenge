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
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) {
        // Write your code here.
        ArrayList<Integer> view = new ArrayList<>();

        leftV(root, view, 0);
        return view;
    }

    static void leftV(TreeNode<Integer> curr, ArrayList<Integer> view, int currDepth) {
        if (curr == null)
            return;
        if (currDepth == view.size())
            view.add(curr.data);

        leftV(curr.left, view, currDepth + 1);
        leftV(curr.right, view, currDepth + 1);
    }
}
