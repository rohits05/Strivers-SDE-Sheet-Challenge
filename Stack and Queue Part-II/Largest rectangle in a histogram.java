import java.util.*;

public class Solution {
    public static int[] prevSmaller(ArrayList<Integer> arr) {
        int[] prev = new int[arr.size()];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.size(); i++) {
            while (!st.isEmpty() && arr.get(st.peek()) >= arr.get(i))
                st.pop();
            if (st.isEmpty())
                prev[i] = -1;
            else
                prev[i] = st.peek();
            st.push(i);
        }
        return prev;
    }

    public static int[] nextSmaller(ArrayList<Integer> arr) {
        int[] next = new int[arr.size()];
        Stack<Integer> st = new Stack<>();
        for (int i = arr.size() - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr.get(st.peek()) >= arr.get(i))
                st.pop();
            if (st.isEmpty())
                next[i] = arr.size();
            else
                next[i] = st.peek();

            st.push(i);
        }
        return next;
    }

    public static int largestRectangle(ArrayList<Integer> heights) {
        // Write your code here.
        int[] ps = prevSmaller(heights);
        int[] ns = nextSmaller(heights);
        int maxAns = 0;
        for (int i = 0; i < heights.size(); i++) {
            int cur = (ns[i] - ps[i] - 1) * heights.get(i);
            maxAns = Math.max(cur, maxAns);
        }
        return maxAns;
    }
}