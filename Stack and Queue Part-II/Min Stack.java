import java.util.*;
import java.io.*;

public class Solution {

    static class MinStack {
        static int[] arr;
        static int[] mina;
        static int i, ci, min;

        MinStack() {
            arr = new int[100000];
            mina = new int[100000];
            min = Integer.MAX_VALUE;
            i = -1;
            ci = 0;
        }

        // Function to add another element equal to num at the top of stack.
        void push(int num) {
            mina[ci] = Math.min(min, num);
            min = mina[ci];
            arr[ci++] = num;
            i++;
        }

        boolean empty() {
            if (ci == 0)
                return true;
            else
                return false;
        }

        // Function to remove the top element of the stack.
        int pop() {
            if (!empty()) {
                ci--;
                int b = arr[i];
                i--;
                if (i != -1)
                    min = mina[i];
                else
                    min = Integer.MAX_VALUE;
                return b;
            }
            return -1;
        }

        // Function to return the top element of stack if it is present. Otherwise
        // return -1.
        int top() {
            if (!empty())
                return arr[i];
            return -1;
        }

        // Function to return minimum element of stack if it is present. Otherwise
        // return -1.
        int getMin() {
            if (!empty())
                return min;
            return -1;
        }
    }
}