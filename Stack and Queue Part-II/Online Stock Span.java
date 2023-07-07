import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for (int i = 0; i < price.size(); i++) {
            while (st.peek() != -1 && price.get(st.peek()) <= price.get(i))
                st.pop();

            if (st.peek() == -1)
                ans.add(i + 1);
            else
                ans.add(i - st.peek());

            st.push(i);
        }

        return ans;
    }
}