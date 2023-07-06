import java.util.*;
import java.io.*;

public class Solution {

    public static int[] nextGreater(int[] arr, int n) {
        // Write Your code here
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] >= st.peek())
                st.pop();
            if (st.isEmpty())
                res[i] = -1;
            else
                res[i] = st.peek();
            st.push(arr[i]);
        }

        return res;
    }
}
