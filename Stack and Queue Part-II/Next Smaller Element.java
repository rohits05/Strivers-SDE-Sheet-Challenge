import java.util.*;
import java.io.*;

public class Solution {
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        // Write your code here.
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = arr.size() - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() >= arr.get(i))
                st.pop();
            if (st.isEmpty())
                ans.add(-1);
            else
                ans.add(st.peek());
            st.push(arr.get(i));
        }

        Collections.reverse(ans);
        return ans;
    }
}